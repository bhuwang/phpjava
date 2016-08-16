package com.lftechnology.phpjava.ems.entities;

/**
 * User
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class User {
    private final static String TABLE = "users";
    protected int id;
    protected String username;
    protected String password;
    protected boolean isTerminated;


    public User() {
    }

    public User(String username, String password, boolean isTerminated) {
        this.username = username;
        this.password = password;
        this.isTerminated = isTerminated;
    }

    public int getId() {
        return this.id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
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
