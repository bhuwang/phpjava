package com.lftechnology.phpjava.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.phpjava.ems.entities.User;

/**
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com>
 */

public class LoginDao {
    private Connection conn;

    public LoginDao() {
        DBConnection dbconn = new DBConnection();
        conn = dbconn.getConnection();
    }

    public User validateUser(String username, String password) {
        User user = new User();
        PreparedStatement pst = null;
        ResultSet rst = null;

        String sql =
                "select u.*,e.role from users u left join employees e on a.id = e.user_id where username = ? and password = ? and is_terminated = 0";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            rst = pst.executeQuery();

            if (rst.next()) {
                user.setUsername(rst.getString("username"));
                user.setPassword(rst.getString("password"));
                user.setIsTerminated(rst.getBoolean("is_terminated"));
                user.setId(rst.getInt("id"));

            } else {
                user.setId(0);
            }
            conn.close();
            pst.close();
            rst.close();

        } catch (SQLException e) {
            System.out.println("validateUser() Error: " + e.getMessage());
        }

        return user;

    }

}
