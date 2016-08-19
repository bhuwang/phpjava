
package com.lftechnology.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.appinterfaces.AppUserInterface;
import com.lftechnology.entities.Employee;
import com.lftechnology.entities.User;
import com.lftechnology.entities.Role;

/**
 * Handles the operation for login of the user
 * 
 * @author achyut
 *
 */

public class UserDao implements AppUserInterface {

    /**
     * Authenticate a user
     * 
     * @author achyut
     * @param employee
     */
    @Override
    public Employee authenticate(User user) {

        Employee employee = new Employee();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = DbAdapter.setConnection();

        String sql = "select * from employee where username= ? and password= ? and is_terminated=false";
        if (con == null) {
            System.out.println("Cannot connect to database");
            return employee;
        }

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

            rs = pst.executeQuery();

            if (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setIsTerminated(rs.getBoolean("is_terminated"));
                employee.setDepartment(rs.getString("department"));
                employee.setFullName(rs.getString("fullname"));
                employee.setAddress(rs.getString("address"));
                Role ut = Role.valueOf(rs.getString("role"));
                employee.setRole(ut);
            } else {
                employee.setId(0);
            }
            con.close();
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error has been encountered:" + e.getMessage());
        }
        return employee;
    }
}
