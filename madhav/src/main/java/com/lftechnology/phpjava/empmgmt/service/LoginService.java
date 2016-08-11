package main.java.com.lftechnology.phpjava.empmgmt.service;

import main.java.com.lftechnology.phpjava.empmgmt.dao.LoginDao;

public class LoginService {
    public String username;
    public String password;

    public LoginService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String checkLogin() {
        LoginDao loginDao = new LoginDao();
        String role = loginDao.getUserRole(this.username, this.password);
        return role;
    }
}
