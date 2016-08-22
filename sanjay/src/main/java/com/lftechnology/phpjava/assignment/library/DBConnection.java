package com.lftechnology.phpjava.assignment.library;
import com.lftechnology.phpjava.assignment.constant.DBConstant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DbConnection
 *
 * @author Sanjay Shiwakoti <sanjayshiwakoti@lftechnology.com>
 * @since August, 12 2016
 */
public class DBConnection {
    private static Properties properties = new Properties();
    private static Connection connection = null; 
    
    public  DBConnection() {
        try {            
            properties.load(getInputProperty());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public InputStream getInputProperty() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir") + DBConstant.DB_CONFIG_PATH +"db.properties";
        InputStream inputProperty = new FileInputStream(filePath);
        return inputProperty;
    }

    /**
     * Connect the database and connect Mysql Database and return
     * Connection
     *
     * @author Sanjay Shiwakoti <sanjayshiwakoti@lftechnology.com>
     * @return Connection Mysql Connection
     */
    public static Connection getConnection() {
        
        try {
            Class.forName(properties.getProperty(DBConstant.DB_DRIVER));
            connection = DriverManager.getConnection(
                    properties.getProperty(DBConstant.DB_URL),
                    properties.getProperty(DBConstant.DB_USERNAME),
                    properties.getProperty(DBConstant.DB_PASSWORD)
            );
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }   
}