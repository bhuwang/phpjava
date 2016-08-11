package main.java.com.lftechnology.phpjava.empmgmt.view;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;
import main.java.com.lftechnology.phpjava.main.Scanner;

public class MenuView {
    private String role;
    private String[] adminMenu = { "1. List Employees", "2. Add Employee", "3. Delete Employee", "0. Exit" };
    private String[] normalMenu = { "1. List Employees", "0. Exit" };
    private String[] currentMenu;

    public MenuView(String role) {
        this.role = role;
        if (this.role == "admin") {
            this.currentMenu = this.adminMenu;
        } else {
            this.currentMenu = this.normalMenu;
        }
    }

    public String getMenu() {
        System.out.println("Please enter the action to perform:");
        for (String option : this.currentMenu) {
            System.out.println(option);
        }
        String option = IOService.input();
        return option;
    }
}
