package main.java.com.lftechnology.phpjava.empmgmt.controller;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;
import main.java.com.lftechnology.phpjava.empmgmt.service.LoginService;
import main.java.com.lftechnology.phpjava.empmgmt.utils.Task;
import main.java.com.lftechnology.phpjava.empmgmt.view.LoginView;
import main.java.com.lftechnology.phpjava.empmgmt.view.MenuView;

public class Employee {

    public static void main(String[] args) {
        LoginView lv = new LoginView();
        String[] loginData = lv.login();
        LoginService ls = new LoginService(loginData[0], loginData[1]);
        String role = ls.checkLogin();
        if (role == "") {
            IOService.output("Invalid Login, exiting");
            System.exit(0);
        }
        MenuView menu = new MenuView(role);
        String option = menu.getMenu();

        Task.runTask(option);
    }

    public void listEmployees() {

    }

    public void addEmployee() {

    }

    public void deleteEmployee() {

    }

}
