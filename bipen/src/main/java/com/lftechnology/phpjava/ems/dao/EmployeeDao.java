package com.lftechnology.phpjava.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.utils.DBConnection;

/**
 * Employee DAO
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com>
 *
 */
public class EmployeeDao {
    private Connection conn = DBConnection.getConnection();
    protected PreparedStatement pst = null;
    protected ResultSet rst = null;

    public Integer insertUserAndEmployee(Employee emp) throws SQLException {

        int lastInsertedId = 0;
        String sql = "Insert into users (username, password, is_terminated) VALUES (?, ?, 0)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, emp.getUsername());
        pst.setString(2, emp.getPassword());

        pst.executeUpdate();
        rst = pst.getGeneratedKeys();
        if (rst.next()) {
            lastInsertedId = rst.getInt(1);
        }

        String employeeSql = "INSERT INTO employees (fullname, address, department, role, user_id) VALUES ( ?, ? , ?, ?,?);";
        pst = conn.prepareStatement(employeeSql);
        pst.setString(1, emp.getFullName());
        pst.setString(2, emp.getAddress());
        pst.setString(3, emp.getDepartment());
        pst.setString(4, emp.getRole());
        pst.setInt(5, lastInsertedId);

        return pst.executeUpdate();

    }
}
