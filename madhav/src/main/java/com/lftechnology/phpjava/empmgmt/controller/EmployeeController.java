package main.java.com.lftechnology.phpjava.empmgmt.controller;

import java.sql.ResultSet;

import main.java.com.lftechnology.phpjava.empmgmt.service.UserService;
import main.java.com.lftechnology.phpjava.empmgmt.service.EmpService;
import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;
import main.java.com.lftechnology.phpjava.empmgmt.service.LoginService;
import main.java.com.lftechnology.phpjava.empmgmt.utils.Session;
import main.java.com.lftechnology.phpjava.empmgmt.utils.Task;
import main.java.com.lftechnology.phpjava.empmgmt.view.EmpView;
import main.java.com.lftechnology.phpjava.empmgmt.view.LoginView;
import main.java.com.lftechnology.phpjava.empmgmt.view.MenuView;

public class EmployeeController {
    public static void main(String[] args) {
        UserService.checkDefaultUser();
        Session.role = LoginController.Login();
        MenuController.showMenu();
    }

    public void listEmployees() {
        EmpService es = new EmpService();
        ResultSet rs = es.listEmployees();
        EmpView ev = new EmpView();
        ev.list(rs);
        MenuController.showMenu();
    }

    public void addEmployee() {
        EmpView ev = new EmpView();
        String[] empData = ev.add();
        EmpService es = new EmpService();
        es.addEmployee(empData);
        MenuController.showMenu();
    }

    public void deleteEmployee() {
        EmpView ev = new EmpView();
        String empname = ev.delete();
        EmpService es = new EmpService();
        es.deleteEmployee(empname);
        MenuController.showMenu();
    }

}
