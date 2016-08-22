package com.lftechnology.phpjava.assignment.entity;

/**
 * Employee
 *
 * @author Sanjay Shiwakoti <sanjayshiwakoti@lftechnology.com>
 * @since August, 12 2016
 */
public class Employee extends User {
    protected Integer employeeid;
    protected String fullname;
    protected String address;
    protected String department;
    protected String role;
    protected Integer userId;
    
    public Employee() {
        super();
    }

    public Employee(String fullname, String address, String department,String role) {
        super();
        this.fullname = fullname;
        this.address = address;
        this.department = department;
        this.role = role;
    }
    

    public Employee setEmployeeId(Integer employeeid) {
        this.employeeid = employeeid;
        return this;
    }

    public Integer getEmployeeID() {
        return employeeid;
    }

    public String getFullname() {
        return fullname;
    }

    public Employee setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Employee setDepartment(String department) {
        this.department = department;
        return this;
    }


    public String getRole() {
        return role;
    }

    public Employee setRole(String role) {
        this.role = role;
        return this;
    }
        
    public int getUserId() {
        return userId;
    }

    public User setEmployeeId(int userId) {
        this.userId = userId;
        return this;
    }
}