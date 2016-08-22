package com.lftechnology.employemanagement.controller.UserController;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.employemanagement.service.UserService;

public class User {
	
	public static void login(String username, String password) throws SQLException{
		ResultSet resultSet = UserService.verfiyUser(username, password);
		if (resultSet.next()) {
			System.out.println(resultSet.getString("username"));
		} else {
			System.out.println("Failed");
		}
	}
}


