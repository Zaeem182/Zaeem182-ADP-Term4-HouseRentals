/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.ac.cput.term4project.houserentals.connection.DbConnection;
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
}
