package com.lftechnology.com.phpjava.employeemgmtsystem.entities;

public class User {

    private int id;
    private String username;
    private String password;
    private boolean isTerminated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsTerminated() {
        return isTerminated;
    }

    public void setIsTerminated(boolean isTerminated) {
        this.isTerminated = isTerminated;
    }
}
