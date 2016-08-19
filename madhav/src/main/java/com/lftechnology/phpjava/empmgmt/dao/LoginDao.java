package main.java.com.lftechnology.phpjava.empmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class LoginDao {
    private Connection conn;
    public LoginDao() {
        DBConnection dbconn = new DBConnection();
        conn = dbconn.getConnection();
    }
    
    public String getUserRole(String username, String password) {
        PreparedStatement pst = null;
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getString(4);
            } else {
                return null;
            }

        } catch (SQLException e) {
            IOService.output(e.getMessage());
        } catch (Exception e) {
            IOService.output(e.getMessage());
        }
        return "";
    }
}
