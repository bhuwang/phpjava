package com.lftechnology.phpjava.ems.entities;

public class Employee extends User {
    protected String fullName;
    protected String department;
    protected String address;

    protected String role;

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     *            the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     *            the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     * @return
     */
    public void setRole(String role) {
        this.role = role;
    }

}
