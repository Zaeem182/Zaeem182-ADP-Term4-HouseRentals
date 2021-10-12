/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import za.ac.cput.term4project.houserentals.connection.DbConnection;
import za.ac.cput.term4project.houserentals.domain.Customer;
import za.ac.cput.term4project.houserentals.domain.Employers;

/**
 *
 * @author Zaeem
 * @author Ali Mohamed - 219113505
 */
public class EmployersDao {
    private final Connection con;
    
    public EmployersDao() throws SQLException{
        con = DbConnection.derbyConnection();
    }
    
    public Employers add(Employers employer ){
        String insertSQL = "INSERT INTO employers VALUES (?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, employer.getEmployerId());
            ps.setString(2, employer.getfName());
            ps.setString(3, employer.getlName());
            ps.setBoolean(4, employer.isAdmin());
            ps.setBoolean(5, employer.isActive());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return employer;
    }
    
    public ArrayList<Employers> getAll(){
        String getAll_SQL = "SELECT * FROM employers";
        ArrayList<Employers> employerArray = new ArrayList<>();
        
        try{
            PreparedStatement ps = this.con.prepareStatement(getAll_SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int employerId = rs.getInt("id");
                String fName = rs.getString("fname");
                String lName = rs.getString("lname");
                boolean isAdmin = rs.getBoolean("admin");
                boolean isActive = rs.getBoolean("active");
                
                Employers employers =  new Employers(employerId, fName, lName, isActive, isAdmin);
                employerArray.add(employers);
            }
            rs.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return employerArray;
    }
    
    public Boolean employeeLogin(Employers employee){
        String login_SQL = "SELECT * FROM employers WHERE id=? AND lname=? AND admin = false";
        
        Boolean valid = false;
        try{
            PreparedStatement ps = this.con.prepareStatement(login_SQL);
            
            ps.setInt(1, employee.getEmployerId());
            ps.setString(2, employee.getlName());
            
            ResultSet rs = ps.executeQuery();
            valid = rs.next();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return valid;
    }
    
    public Boolean employeeAdminLogin(Employers employee){
        String login_SQL = "SELECT * FROM employers WHERE id=? AND lname=? AND admin = true";
        
        Boolean valid = false;
        try{
            PreparedStatement ps = this.con.prepareStatement(login_SQL);
            
            ps.setInt(1, employee.getEmployerId());
            ps.setString(2, employee.getlName());
            
            ResultSet rs = ps.executeQuery();
            valid = rs.next();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return valid;
    }
    
    public Employers update(Employers employee){
        try {
            String updateSQL = "UPDATE employers Set active = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(updateSQL);
            
            ps.setBoolean(1, employee.isActive());
            ps.setInt(2, employee.getEmployerId());
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return employee;
    }
}
