package main.java.com.lftechnology.phpjava.empmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class UserDao {
    private Connection conn;
    public UserDao() {
        DBConnection dbconn = new DBConnection();
        this.conn = dbconn.getConnection();
    }
    
    public ResultSet getAdminUsers() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE role='admin'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            IOService.output(e.getMessage());
        } catch (Exception e) {
            IOService.output(e.getMessage());
        }
        return rs;
    }
    
    public void addUser(String[] userData) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO user(fullname, username, password, role) VALUES(?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, userData[0]);
            pst.setString(2, userData[1]);
            pst.setString(3, userData[2]);
            pst.setString(4, userData[3]);
            pst.executeUpdate();
        } catch (SQLException e) {
            IOService.output(e.getMessage());
        } catch (Exception e) {
            IOService.output(e.getMessage());
        }
    }
}
