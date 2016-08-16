package com.lftechnology.phpjava.ems.entities;

import com.lftechnology.phpjava.ems.enums.Role;

/**
 * Employee
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class Employee extends User {
    private static final String TABLE = "employee";
    protected String fullname;
    protected String address;
    protected String department;
    protected Role role;
    protected int userId;

    public Employee(){
        super();
    }


    public Employee(String fullname, String address, String department, Role role, int userId) {
        super();
        this.fullname = fullname;
        this.address = address;
        this.department = department;
        this.role = role;
        this.userId = userId;
    }

    public String getFullname() {
        return this.fullname;
    }

    public Employee setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDepartment() {
        return this.department;
    }

    public Employee setDepartment(String department) {
        this.department = department;
        return this;
    }


    public Role getRole() {
        return this.role;
    }

    public Employee setRole(Role role) {
        this.role = role;
        return this;
    }

    public int getUserId() {
        return this.userId;
    }

    public Employee setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String[] toArray(){
        String[] emp = new String[5];
        emp[0] = String.valueOf(this.getUserId());
        emp[1] = this.getFullname();
        emp[2] = this.getAddress();
        emp[3] = this.getRole().toString();
        emp[4] = this.getDepartment();
        return  emp;
    }
}
