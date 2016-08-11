package main.java.com.lftechnology.phpjava.empmgmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class DBConnection {
    private String dbuser = "root";
    private String dbpass = "root";
    private String database = "jdbc:mysql://localhost:3306/empmgmt";
    public DBConnection(){
        
    }
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.database, this.dbuser, this.dbpass);
        } catch(Exception e) {
            IOService.output(e.getMessage());
        }
        return conn;
    }
    
}
