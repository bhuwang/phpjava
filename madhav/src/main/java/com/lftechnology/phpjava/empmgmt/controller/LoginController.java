package main.java.com.lftechnology.phpjava.empmgmt.controller;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;
import main.java.com.lftechnology.phpjava.empmgmt.service.LoginService;
import main.java.com.lftechnology.phpjava.empmgmt.view.LoginView;

public class LoginController {
    public static String Login(){
        LoginView lv = new LoginView();
        String[] loginData = lv.login();
        LoginService ls = new LoginService(loginData[0], loginData[1]);
        String role = ls.checkLogin();
        if (role == "") {
            IOService.output("Invalid Login, exiting");
            System.exit(0);
        }
        return role;
    }
}
