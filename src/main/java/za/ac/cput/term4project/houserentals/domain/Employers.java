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
public class Employers implements Serializable{
   
    private int employerId;
    private String fName, lName;
    private boolean active, admin;

    public Employers(int employerId, String fName, String lName, boolean active, boolean admin) {
        this.employerId = employerId;
        this.fName = fName;
        this.lName = lName;
        this.active = active;
        this.admin = admin;
    }

    public Employers(int employerId, boolean active) {
        this.employerId = employerId;
        this.active = active;
    }
    
    public Employers(int employerId, String lName){
        this.employerId = employerId;
        this.lName = lName;
    }
    
    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getEmployerId() {
        return employerId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "Employers{" + "employerId=" + employerId + ", fName=" + fName + ", lName=" + lName + ", active=" + active + ", admin=" + admin + '}';
    }
    
}
