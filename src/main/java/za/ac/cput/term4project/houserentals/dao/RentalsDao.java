/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String insertSQL = "INSERT INTO rental VALUES (?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, rental.getRentId());
            ps.setDate(2, rental.getDate());
            ps.setInt(3, rental.getCustomerId());
            ps.setInt(4, rental.getHouseId());
            ps.setDouble(5, rental.getCommission());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return rental;
    }
    
    public ArrayList<Rental> getAll(){
        String getAll_SQL = "SELECT * FROM rental";
        ArrayList<Rental> rentalArray = new ArrayList<>();
        
        try{
            PreparedStatement ps = this.con.prepareStatement(getAll_SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int rentalId = rs.getInt("id");
                Date date = rs.getDate("date");
                int customerId = rs.getInt("customerid");
                int houseId = rs.getInt("houseid");
                double commission = rs.getDouble("commission");
                
                Rental rental =  new Rental(rentalId, customerId, houseId, date, commission);
                rentalArray.add(rental);
            }
            rs.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return rentalArray;
    }
    
    public ArrayList<Rental> getCommissionAll(){
        String getAll_SQL = "SELECT commission FROM rental";
        ArrayList<Rental> rentalArray = new ArrayList<>();
        
        try{
            PreparedStatement ps = this.con.prepareStatement(getAll_SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                double commission = rs.getDouble("commission");
                
                Rental rental =  new Rental(commission);
                rentalArray.add(rental);
            }
            rs.close();
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return rentalArray;
    }
}
