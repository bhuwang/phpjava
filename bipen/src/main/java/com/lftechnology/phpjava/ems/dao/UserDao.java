package com.lftechnology.phpjava.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.utils.ConsoleWriter;
import com.lftechnology.phpjava.ems.utils.DBConnection;

/**
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com>
 */

public class UserDao {
    private Connection conn = DBConnection.getConnection();
    protected PreparedStatement pst = null;
    protected ResultSet rst = null;

    public int checkDefaultUser() throws SQLException {
        int result = 0;
        String sql = "select count(*) from users u left join employees e on u.id = e.user_id where is_terminated = 0 and e.role = 'ADMIN'";

        pst = conn.prepareStatement(sql);
        rst = pst.executeQuery();
        if (rst.next()) {
            result = rst.getInt(1);
        }

        return result;
    }

    public Employee validateUser(String username, String password) {
        Employee employee = new Employee();

        String sql =
                "select u.*,e.role from users u left join employees e on u.id = e.user_id where username = ? and password = ? and is_terminated = 0";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            rst = pst.executeQuery();

            if (rst.next()) {
                employee.setUsername(rst.getString("username"));
                employee.setPassword(rst.getString("password"));
                employee.setIsTerminated(rst.getBoolean("is_terminated"));
                employee.setId(rst.getInt("id"));
                employee.setRole(rst.getString("role"));
            } else {
                employee.setId(0);
            }
            conn.close();
            pst.close();
            rst.close();

        } catch (SQLException e) {
            ConsoleWriter.setErrorMessageToConsole("Error while validating user : " + e.getMessage());
        }

        return employee;

    }

    public int addUser(User user) {
        int lastInsertedId = 0;
        String sql = "Insert into users (username, password, is_terminated) VALUES (?, ?, 0)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(1, user.getPassword());

            pst.executeUpdate();
            rst = pst.getGeneratedKeys();
            if (rst.next()) {
                lastInsertedId = rst.getInt(1);
            }
        } catch (SQLException e) {
            ConsoleWriter.setErrorMessageToConsole("SQL Exception while inserting User : " + e.getMessage());
        }

        return lastInsertedId;
    }

}
