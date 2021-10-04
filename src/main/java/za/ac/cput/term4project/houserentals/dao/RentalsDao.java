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
import za.ac.cput.term4project.houserentals.domain.Rental;

/**
 *
 * @author Zaeem Petersen - 219010145
 * @author Ali Mohamed - 219113505
 */
public class RentalsDao {
    private final Connection con;
    
    public RentalsDao() throws SQLException{
        con = DbConnection.derbyConnection();
    }
    
    public Rental add(Rental rental){
        String insertSQL = "INSERT INTO rental VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, rental.getRentId());
            ps.setDate(2, rental.getDate());
            ps.setInt(3, rental.getCustomerId());
            ps.setInt(4, rental.getHouseId());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return rental;
    }
}
