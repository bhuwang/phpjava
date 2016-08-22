package com.lftechnology.employemanagement.enums;

public enum Role {
	
	ADMIN("admin"), USER("user");

	private String role;

	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}
}
