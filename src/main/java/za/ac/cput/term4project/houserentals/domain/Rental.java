/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class Rental implements Serializable{
    
    private int rentId, customerId, houseId;
    private Date date;
    private double commission;

    public Rental(int rentId, int customerId, int houseId, Date date, double commission) {
        this.rentId = rentId;
        this.customerId = customerId;
        this.houseId = houseId;
        this.date = date;
        this.commission = commission;
    }

    public Rental(double commission)
    {
        this.commission = commission;
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

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
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
        return "Rental{" + "rentId=" + rentId + ", customerId=" + customerId + ", houseId=" + houseId + ", date=" + date + ", commission=" + commission + '}';
    }

    
    
}
