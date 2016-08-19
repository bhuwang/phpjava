package com.lftechnology.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * DBAdapter for Mysql
 * @author achyut
 *
 */
public class DbAdapter {
    
    private DbAdapter() {
        
    }
    
    /**
     * Get a MYSQL JDBC Connection
     * @return Connection
     */
    public static Connection setConnection() {
        
        Properties prop = new Properties();
        InputStream input = null;        
       
        Connection connection = null;
        try{
            input = new FileInputStream("src/main/java/com/lftechnology/dao/dbconfig.properties");
            prop.load(input);
            String username = prop.getProperty("dbuser");
            String password = prop.getProperty("dbpass");
            String url = prop.getProperty("dburl");
            connection = DriverManager.getConnection(url, username, password);
            
            input.close();
        } catch(FileNotFoundException fnf){
            System.out.println("File not found");
        } catch (Exception e) {
            
            System.out.println("Couldn't connect to database ="+e.getMessage());
        }        
        return connection;
    }
}
