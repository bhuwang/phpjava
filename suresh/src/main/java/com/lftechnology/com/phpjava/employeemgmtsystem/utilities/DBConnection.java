package com.lftechnology.com.phpjava.employeemgmtsystem.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";
    private static final String MYSQL_DATABASE = "jdbc:mysql://localhost:3306/employee_mgmt_system";

    public static Connection getMYSQLConn() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(MYSQL_DATABASE, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("An exception occured.");
            System.err.println(e.getMessage());
        }

        return connection;
    }

    // public static void closeMYSQLConn() {
    // Connection connection = null;
    //
    // try {
    // if (connection != null) {
    // connection.close();
    // }
    // } catch (SQLException e) {
    // System.err.println("An exception occured.");
    // System.err.println(e.getMessage());
    // }
    //
    // }
}
