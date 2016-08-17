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

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public Employee() {
        super();
    }


    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param fullname
     * @param address
     * @param department
     * @param role
     * @param userId
     */
    public Employee(String fullname, String address, String department, Role role, int userId) {
        super();
        this.fullname = fullname;
        this.address = address;
        this.department = department;
        this.role = role;
        this.userId = userId;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public String getFullname() {
        return this.fullname;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param fullname
     * @return
     */
    public Employee setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param address
     * @return
     */
    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param department
     * @return
     */
    public Employee setDepartment(String department) {
        this.department = department;
        return this;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param role
     * @return
     */
    public Employee setRole(Role role) {
        this.role = role;
        return this;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param userId
     * @return
     */
    public Employee setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public String[] toArray() {
        String[] emp = new String[5];
        emp[0] = String.valueOf(this.getUserId());
        emp[1] = this.getFullname();
        emp[2] = this.getAddress();
        emp[3] = this.getRole().toString();
        emp[4] = this.getDepartment();
        return emp;
    }
}
