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
    
    private int rentId;
    private Date date;

    public Rental(int no, Date date) {
        this.rentId = no;
        this.date = date;
    }

    public void setNo(int no) {
        this.rentId = no;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNo() {
        return rentId;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Rental{" + "no=" + rentId + ", date=" + date + '}';
    }
    
}
