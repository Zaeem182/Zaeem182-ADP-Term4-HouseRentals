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
import za.ac.cput.term4project.houserentals.domain.Customer;

/**
 *
 * @author Zaeem
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
    
    
}
