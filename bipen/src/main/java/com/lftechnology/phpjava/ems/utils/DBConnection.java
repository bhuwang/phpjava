package com.lftechnology.phpjava.ems.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * DB Connection Class
 * 
 * 
 * @author Bipen Chhetri
 * 
 */
public class DBConnection {

    /**
     * Creates database connection
     * 
     * @return Connection
     * @throws Exception
     * @author Bipen Chhetri
     */
    public static Connection getConnection() {

        Connection conn = null;
        Properties properties = getProperties();
        try {
            Class.forName(properties.getProperty("driver"));

            String database = properties.getProperty("database");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            conn = DriverManager.getConnection(database, username, password);
        } catch (Exception e) {
            ConsoleWriter.setErrorMessageToConsole("Couldn't connect to database =" + e.getMessage());
        }

        return conn;

    }

    /**
     * Get db properties from configuration file.
     * 
     * @return
     * @throws IOException
     * @author Bipen Chhetri
     */
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            String filePath = "src/main/java/com/lftechnology/phpjava/ems/config/db.properties";
            InputStream io = new FileInputStream(filePath);

            properties.load(io);
            io.close();

        } catch (IOException e) {
            ConsoleWriter.setErrorMessageToConsole("IO Exception = " + e.getMessage());
        }
        return properties;
    }

}
