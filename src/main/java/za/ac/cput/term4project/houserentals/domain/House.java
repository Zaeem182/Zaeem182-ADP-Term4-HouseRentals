/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.domain;

/**
 *
 * @author Ali
 * @author Zaeem Petersen (219010145)
 */
public class House {
    
    private int id, numberOfRooms;
    private String  location;
    private double rent;

    public House(int id, int numberOfRooms, String location, double rent) {
        this.id = id;
        this.numberOfRooms = numberOfRooms;
        this.location = location;
        this.rent = rent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getLocation() {
        return location;
    }

    public double getRent() {
        return rent;
    }

    @Override
    public String toString() {
        return "House{" + "id=" + id + ", numberOfRooms=" + numberOfRooms + ", location=" + location + ", rent=" + rent + '}';
    }
    
}
