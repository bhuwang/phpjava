package com.lftechnology.employemanagement.repository.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.employemanagement.database.MysqlDB;

public class EmployeeRepository implements EmployeeRepositoryInterface{

	private Connection connection;

	public EmployeeRepository() throws SQLException {
		this.connection = MysqlDB.getConnection();
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet delete(String fullName) throws SQLException {
		String statement = "SELECT * FROM Employee AS e INNER JOIN user AS u ON u.iduser = e.user_id WHERE fullName = ?";
		PreparedStatement preparedStatement = this.connection.prepareStatement(statement);
		preparedStatement.setString(1, fullName);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		return resultSet;
	}



	
}
