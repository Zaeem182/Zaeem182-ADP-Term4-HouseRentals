/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.domain;

import java.sql.Date;

/**
 *
 * @author Ali
 */
public class Rental {
    
    private int rentId, customerId, houseId;
    private Date date;

    public Rental(int rentId, int customerId, int houseId, Date date) {
        this.rentId = rentId;
        this.customerId = customerId;
        this.houseId = houseId;
        this.date = date;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRentId() {
        return rentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getHouseId() {
        return houseId;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Rental{" + "rentId=" + rentId + ", customerId=" + customerId + ", houseId=" + houseId + ", date=" + date + '}';
    }
    
}
