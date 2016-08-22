package com.lftechnology.employemanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.employemanagement.database.MysqlDB;

public class UserService {

	public static ResultSet verfiyUser(String username, String password) throws SQLException {
		String statement = "SELECT * FROM User WHERE is_terminated = 0 AND username = ? AND password = ?";
		Connection connection = MysqlDB.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(statement);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		return resultSet;
	}
}
