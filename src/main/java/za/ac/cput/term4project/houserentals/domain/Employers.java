/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.domain;

/**
 *
 * @author Ali
 */
public class Employers {
   
    private int employerId;
    private String fName, lName, workType;
    private boolean active;

    public Employers(int employerId, String fName, String lName, String workType, boolean active) {
        this.employerId = employerId;
        this.fName = fName;
        this.lName = lName;
        this.workType = workType;
        this.active = active;
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

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getWorkType() {
        return workType;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Employers{" + "employerId=" + employerId + ", fName=" + fName + ", lName=" + lName + ", workType=" + workType + ", active=" + active + '}';
    }
    
}
