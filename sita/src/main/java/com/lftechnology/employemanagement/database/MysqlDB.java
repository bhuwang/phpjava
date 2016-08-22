package com.lftechnology.employemanagement.database;

// To connect to a database, Connection object is required.
import java.sql.Connection;
// The Connection object uses a DriverManager. The DriverManager passes in the database username,  password, and the location of the database.
import java.sql.DriverManager;
// It provides information on a database access error or other errors
import java.sql.SQLException;

public class MysqlDB {

	public static Connection getConnection() throws SQLException{
		Connection connection = null;
		String hostName = "jdbc:mysql://localhost:3306/java_employee_management";
		String userName = "root";
		String password = "password123";
		// DriverManager has a method called getConnection, which need hostname,
		// username and password.
		// If a connection is successful, a Connection object is created. In
		// this case 'conn'
		connection = DriverManager.getConnection(hostName, userName, password);
		return connection;
	}
}
