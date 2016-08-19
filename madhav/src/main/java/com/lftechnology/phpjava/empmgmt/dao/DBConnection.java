package main.java.com.lftechnology.phpjava.empmgmt.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class DBConnection {
    public DBConnection(){
        
    }
    public Connection getConnection(){
        Properties properties = new Properties();
        Connection conn = null;
        try {
            String filePath = "src/main/java/com/lftechnology/phpjava/empmgmt/config/db.properties";
            InputStream input = new FileInputStream(filePath);
            properties.load(input);
            Class.forName(properties.getProperty("driver"));
            conn = DriverManager.getConnection(properties.getProperty("database"), properties.getProperty("user"), properties.getProperty("pass"));
        } catch(Exception e) {
            IOService.output(e.getMessage());
        }
        return conn;
    }
    
}
