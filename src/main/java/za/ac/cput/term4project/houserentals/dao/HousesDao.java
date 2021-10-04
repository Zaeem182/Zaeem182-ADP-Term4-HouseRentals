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
import za.ac.cput.term4project.houserentals.domain.House;

/**
 *
 * @author Zaeem
 * @author Ali Mohamed - 219113505
 */
public class HousesDao {
    private final Connection con;
    
    public HousesDao() throws SQLException{
        con = DbConnection.derbyConnection();
    }
    
    public House add(House house){
        String insertSQL = "INSERT INTO houses VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, house.getId());
            ps.setInt(2, house.getNumberOfRooms());
            ps.setString(3, house.getLocation());
            ps.setDouble(4, house.getRent());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return house;
    }
}
