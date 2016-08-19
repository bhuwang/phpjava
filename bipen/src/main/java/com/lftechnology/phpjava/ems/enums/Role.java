package com.lftechnology.phpjava.ems.enums;

public enum Role {
    ADMIN("ADMIN"), NORMAL("NORMAL");

    protected String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
