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
public class Customer implements Serializable{
    
    private int customerId;
    private String fName, lName, cell;
    private boolean canRent;

    public Customer(int customerId, String fName, String lName, String cell, boolean canRent) {
        this.customerId = customerId;
        this.fName = fName;
        this.lName = lName;
        this.cell = cell;
        this.canRent = canRent;
    }

    public Customer(int customerId, boolean canRent) {
        this.customerId = customerId;
        this.canRent = canRent;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public void setCanRent(boolean canRent) {
        this.canRent = canRent;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getCell() {
        return cell;
    }

    public boolean isCanRent() {
        return canRent;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", fName=" + fName + ", lName=" + lName + ", cell=" + cell + ", canRent=" + canRent + '}';
    }
    
}
