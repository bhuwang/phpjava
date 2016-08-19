package com.lftechnology.phpjava.ems.entities;

public class User {
    protected int id;
    protected String username;
    protected String password;
    protected Boolean isTerminated;

    public User() {
    }

    public User(String username, String password, Boolean isTerminated) {
        this.username = username;
        this.password = password;
        this.isTerminated = isTerminated;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
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
     * @param username
     *            the username to set
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
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isTerminated
     */
    public Boolean getIsTerminated() {
        return isTerminated;
    }

    /**
     * @param isTerminated
     *            the isTerminated to set
     */
    public void setIsTerminated(Boolean isTerminated) {
        this.isTerminated = isTerminated;
    }

}
