package com.lftechnology.employemanagement.entities;

public class User {
	
	protected int id;
	protected String username;
	protected String password;
	protected boolean isTerminated;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isTerminated
	 */
	public boolean isTerminated() {
		return isTerminated;
	}

	/**
	 * @param isTerminated the isTerminated to set
	 */
	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
}
