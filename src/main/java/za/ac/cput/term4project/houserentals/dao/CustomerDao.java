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

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class CustomerDao {
    private final Connection con;

    public CustomerDao() throws SQLException {
        con = DbConnection.derbyConnection();
    }
    
    public Customer add(Customer customer){
        String insertSQL = "INSERT INTO customer VALUES (?, ?, ?, ?, ?)"; // Just testing this way might have to change
        
        try{
           PreparedStatement ps = con.prepareStatement(insertSQL);
           ps.setInt(1, customer.getCustomerId());
           ps.setString(2, customer.getfName());
           ps.setString(3, customer.getlName());
           ps.setString(4, customer.getCell());
           ps.setBoolean(5, customer.isCanRent());
           
           ps.executeUpdate();
           ps.close();
           
        }
        catch(SQLException ex){
            System.out.println("SQLExeption: " + ex.getMessage());
        }
        return customer;
    }
    
    public ArrayList<Customer> getAll(){
        String getAll_SQL = "SELECT * FROM customer";
        ArrayList<Customer> customerArray = new ArrayList<>();
        
        try{
            PreparedStatement ps = this.con.prepareStatement(getAll_SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int customerId = rs.getInt("id");
                String fName = rs.getString("fname");
                String lName = rs.getString("lname");
                String cell = rs.getString("phonenum");
                boolean canRent = rs.getBoolean("canrent");
                
                Customer customer =  new Customer(customerId, fName, lName, cell, canRent);
                customerArray.add(customer);
            }
            rs.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return customerArray;
    }
    
    public Customer update(Customer customer){
        try {
            String updateSQL = "UPDATE customer Set canrent = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(updateSQL);
            
            ps.setBoolean(1, customer.isCanRent());
            ps.setInt(2, customer.getCustomerId());
            
            ps.executeUpdate();
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return customer;
    }
}
