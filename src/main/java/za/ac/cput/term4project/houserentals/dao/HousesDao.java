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
        String insertSQL = "INSERT INTO house VALUES (?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, house.getId());
            ps.setInt(2, house.getNumberOfRooms());
            ps.setString(3, house.getLocation());
            ps.setDouble(4, house.getPrice());
            ps.setBoolean(5, house.isIsRented());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return house;
    }
    
    public ArrayList<House> getAll(){
        String getAll_SQL = "SELECT * FROM house";
        ArrayList<House> houseArray = new ArrayList<>();
        
        try{
            PreparedStatement ps = this.con.prepareStatement(getAll_SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int houseId = rs.getInt("id");
                int numberOfRooms = rs.getInt("noofrooms");
                String location = rs.getString("location");
                double price = rs.getDouble("rent");
                boolean isRented = rs.getBoolean("isrented");
                
                House house =  new House(houseId, numberOfRooms, location, price, isRented);
                houseArray.add(house);
            }
            rs.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return houseArray;
    }
}
