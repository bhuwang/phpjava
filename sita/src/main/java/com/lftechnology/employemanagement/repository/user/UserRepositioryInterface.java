package com.lftechnology.employemanagement.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserRepositioryInterface {

	public void add();
	
	public void update();
	
	public ResultSet delete(String fullName) throws SQLException ;
}
