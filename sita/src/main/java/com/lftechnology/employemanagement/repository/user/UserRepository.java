package com.lftechnology.employemanagement.repository.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.employemanagement.database.MysqlDB;

public class UserRepository implements UserRepositioryInterface{

	private Connection connection;
	
	public UserRepository() throws SQLException {
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
		// TODO Auto-generated method stub
		return null;
	}

}
