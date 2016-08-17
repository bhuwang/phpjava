package com.lftechnology.phpjava.ems.utlis;

import com.lftechnology.phpjava.ems.constants.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DbFactory
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public abstract class DbFactory {
    private static Properties properties = new Properties();
    private static Connection connection = null;


    /**
     * load database configuration for properties file
     *
     * @return
     * @throws IOException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    private static void loadProperties() {

        InputStream input = null;

        try {
            String filePath = "src/main/java/com/lftechnology/phpjava/ems/configs/db.properties";
            input = new FileInputStream(filePath);
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * get database connection
     *
     * @return
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static Connection getConnection() {
        loadProperties();
        try {
            Class.forName(properties.getProperty(Constant.PROPERTY_DRIVER));
            connection = DriverManager.getConnection(
                    properties.getProperty(Constant.PROPERTY_URL),
                    properties.getProperty(Constant.PROPERTY_USERNAME),
                    properties.getProperty(Constant.PROPERTY_PASSWORD)
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
