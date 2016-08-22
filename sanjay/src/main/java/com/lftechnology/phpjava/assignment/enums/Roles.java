package com.lftechnology.phpjava.assignment.enums;
/**
 * Role
 *
 * @author Sanjay Shiwakoti<sanjayshiwakoti@lftechnology.com>
 * @since August, 12 2016
 */
public enum Roles {
    ADMIN("admin"), USER("user");
    private final String role;

    private Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

}