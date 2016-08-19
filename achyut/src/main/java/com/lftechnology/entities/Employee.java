package com.lftechnology.entities;

import com.lftechnology.entities.User;

/**
 * Employee entity on the system
 * @author achyut
 *
 */
public class Employee extends User {
    
    private String fullname;
    private String department;
    private String address;
    private Role role;

    public String getFullName() {

        return fullname;
    }

    public void setFullName(String fullName) {

        this.fullname = fullName;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public Role getRole() {

        return role;
    }

    public void setRole(Role role) {

        this.role = role;
    }

}
