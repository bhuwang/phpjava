package main.java.com.lftechnology.phpjava.empmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class EmpDao {
    private Connection conn;
    public EmpDao() {
        DBConnection dbconn = new DBConnection();
        conn = dbconn.getConnection();
    }
    
    public ResultSet listEmployees() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM employee WHERE is_deleted=0";
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
    
    public ResultSet getEmployeeByName(String empname) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM employee WHERE fullname=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, empname);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            IOService.output(e.getMessage());
        } catch (Exception e) {
            IOService.output(e.getMessage());
        }
        return rs;
    }
    
    public void addEmployee(String[] empData) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO employee(fullname) VALUES(?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, empData[0]);
            pst.executeUpdate();
        } catch (SQLException e) {
            IOService.output(e.getMessage());
        } catch (Exception e) {
            IOService.output(e.getMessage());
        }
    }
    
    public void deleteEmployee(String empname) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM employee WHERE fullname=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, empname);
            pst.executeUpdate();
        } catch (SQLException e) {
            IOService.output(e.getMessage());
        } catch (Exception e) {
            IOService.output(e.getMessage());
        }
    }
}
