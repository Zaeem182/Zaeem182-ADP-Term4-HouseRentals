/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.domain;

import java.io.Serializable;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class House implements Serializable{
    
    private int id;
    private String  numberOfRooms, location;
    private double price;
    private boolean isRented;

    public House(int id, String numberOfRooms, String location, double price, boolean isRented) {
        this.id = id;
        this.numberOfRooms = numberOfRooms;
        this.location = location;
        this.price = price;
        this.isRented = isRented;
    }

    public House(int id, boolean isRented) {
        this.id = id;
        this.isRented = isRented;
    }

    public House(String location) {

        this.location = location;
    } 

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public int getId() {
        return id;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public boolean isIsRented() {
        return isRented;
    }

    @Override
    public String toString() {
        return "House{" + "id=" + id + ", numberOfRooms=" + numberOfRooms + ", location=" + location + ", price=" + price + ", isRented=" + isRented + '}';
    }
    
}
