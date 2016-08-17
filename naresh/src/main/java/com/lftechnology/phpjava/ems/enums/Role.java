package com.lftechnology.phpjava.ems.enums;

/**
 * Role
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public enum Role {
    ADMIN("admin"), USER("user");
    private final String role;

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param role
     */
    private Role(String role) {
        this.role = role;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public String getRole() {
        return this.role;
    }

}
