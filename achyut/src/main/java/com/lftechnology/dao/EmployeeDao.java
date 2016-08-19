
package com.lftechnology.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.appinterfaces.EmployeeInterface;
import com.lftechnology.entities.Employee;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * An implementation for database operation of an employee
 * @author achyut
 *
 */

public class EmployeeDao implements EmployeeInterface {


    
    /**
     * Checks if the username exists on the system
     * @author achyut
     * @param boolean
     */
    @Override
    public boolean isUsernameExists(String name) {

        ResultSet rs = null;
        StringBuilder sql = null;
        Connection con = DbAdapter.setConnection();
        if (con == null) {
            System.out.println("\n Cannot connect to database");
            return false;
        }
        PreparedStatement preparedStmt = null;

        sql = new StringBuilder("select * from employee where username= ?");
       

        try {
            preparedStmt = con.prepareStatement(sql.toString());
            preparedStmt.setString(1, name);
            rs = preparedStmt.executeQuery();
            if(!rs.next())
            {
                return false;
            } else{
                return true;
            }            

        } catch (SQLException e) {
            System.out.println("Error has been encountered:"+e.getMessage());
            return true;
        }
        
    }
    
    /**
     * Add an employee object to database
     * @author achyut
     * @return int count of employee added
     */
    @Override
    public int addEmployee(Employee e) {

        Connection con = DbAdapter.setConnection();
        int count = 0;
        if (con == null) {
            System.out.println("\n Cannot connect to database");
            return count;
        }
        PreparedStatement preparedStmt = null;
        String sql = "insert into employee (username,password,is_terminated,fullname,department,address,role) values(?,?,?,?,?,?,?)";
        try {
            preparedStmt = con.prepareStatement(sql);

            preparedStmt.setString(1, e.getUsername());
            preparedStmt.setString(2, e.getPassword());
            preparedStmt.setBoolean(3, e.getIsTerminated());
            preparedStmt.setString(4, e.getFullName());
            preparedStmt.setString(5, e.getDepartment());
            preparedStmt.setString(6, e.getAddress());
            preparedStmt.setString(7, e.getRole().toString());

            count = preparedStmt.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException e1) {
            System.out.println("The Username Already Taken");
        } catch (SQLException sq) {
            System.out.println("Error has been encountered:"+sq.getMessage());
        }

        return count;
    }
    
    /**
     * Deletes an employee from the system
     * @author achyut
     * @return int
     */

    @Override
    public int deleteEmployee(Employee e) {
        Connection con = DbAdapter.setConnection();
        int count = 0;
        if (con == null) {
            System.out.println("\n Cannot connect to database");
            return count;
        }
        PreparedStatement preparedStmt = null;
        String sql = "delete from employee where fullname = ? ";
        try {
            preparedStmt = con.prepareStatement(sql);

            preparedStmt.setString(1, e.getFullName());
            count = preparedStmt.executeUpdate();

        } catch (SQLException sq) {
            System.out.println("Error has been encountered:"+sq.getMessage());
        }
        return count;
    }

    /**
     * Search an employee on the system
     * @author achyut
     * @param employee
     */
    @Override
    public ResultSet searchEmployee(Employee employee) {

        ResultSet rs = null;
        StringBuilder sql = null;
        Connection con = DbAdapter.setConnection();
        if (con == null) {
            System.out.println("\n Cannot connect to database");
            return rs;
        }
        PreparedStatement preparedStmt = null;

        sql = new StringBuilder("select * from employee where 1=1 ");
        if (!"".equals(employee.getFullName())) {
            sql.append("and fullname like '");
            sql.append(employee.getFullName());
            sql.append("%'");
        }
        if (!"".equals(employee.getAddress())) {
            sql.append(" and address like '");
            sql.append(employee.getAddress());
            sql.append("%'");
        }
        if (!"".equals(employee.getDepartment())) {
            sql.append(" and department like '");
            sql.append(employee.getDepartment());
            sql.append("%'");
        }

        try {
            preparedStmt = con.prepareStatement(sql.toString());
            rs = preparedStmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println("Error has been encountered:"+ex.getMessage());
        }

        return rs;
    }

    /**
     * Terminate an employee from the system
     * @author achyut
     * @return int
     */
    @Override
    public int terminateEmployee(Employee e) {

        Connection con = DbAdapter.setConnection();
        int count = 0;
        if (con == null) {
            System.out.println("\n Cannot connect to database");
            return count;
        }
        PreparedStatement preparedStmt = null;
        String sql = "update employee set is_terminated=1 where fullname=? ";
        try {
            preparedStmt = con.prepareStatement(sql);

            preparedStmt.setString(1, e.getFullName());

            count = preparedStmt.executeUpdate();

        } catch (SQLException sq) {
            System.out.println("Error has been encountered:"+sq.getMessage());
        }
        return count;
    }

    /**
     * Edit the profile of an employee
     * @author achyut
     * @param employee
     */
    
    @Override
    public Employee editEmployeeDetails(Employee employee) {

        Connection con = DbAdapter.setConnection();
        int count = 0;
        if (con == null) {
            System.out.println("\n Cannot connect to database");
            return employee;
        }
        PreparedStatement preparedStmt = null;
        String sql = "update employee set username=?,password=?,fullname=?,department=?,address=? where is_terminated=0 and id=?";
        try {
            preparedStmt = con.prepareStatement(sql);

            preparedStmt.setString(1, employee.getUsername());
            preparedStmt.setString(2, employee.getPassword());
            preparedStmt.setString(3, employee.getFullName());
            preparedStmt.setString(4, employee.getDepartment());
            preparedStmt.setString(5, employee.getAddress());
            preparedStmt.setInt(6, employee.getId());

            count = preparedStmt.executeUpdate();

            if (count == 0) {
                System.out.println("The entered data was not updated. Please re-try.");
            } else {
                System.out.println("Edit complete..");
            }
        } catch (SQLException sq) {
            System.out.println("Error has been encountered:"+sq.getMessage());
        }
        return employee;
    } 

   

}
