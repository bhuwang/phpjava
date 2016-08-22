package com.lftechnology.phpjava.assignment.entity;

/**
 * Employee
 *
 * @author Sanjay Shiwakoti <sanjayshiwakoti@lftechnology.com>
 * @since August, 12 2016
 */
public class User {
    protected int id;
    protected String username;
    protected String password;
    protected boolean isTerminated;
    protected int employeeId;
    
    public User() {
        
    }

    public User(String username, String password, boolean isTerminated) {
        this.username = username;
        this.password = password;
        this.isTerminated = isTerminated;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public User setTerminated(boolean terminated) {
        isTerminated = terminated;
        return this;
    }
}