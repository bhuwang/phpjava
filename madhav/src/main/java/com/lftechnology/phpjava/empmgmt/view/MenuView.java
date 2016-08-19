package main.java.com.lftechnology.phpjava.empmgmt.view;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;
import main.java.com.lftechnology.phpjava.main.Scanner;

public class MenuView {
    private String role;
    private String[] adminMenu = { "1. List Employees", "2. Add Employee", "3. Delete Employee", "0. Exit" };
    private String[] normalMenu = { "1. List Employees", "0. Exit" };

    public MenuView(String role) {
        this.role = role;
    }

    public String getMenu() {
        IOService.output("Please enter the action to perform:");
        if (this.role.equals("admin")) {
            for (String oa : this.adminMenu) {
                IOService.output(oa);
            }
        } else {
            for (String on : this.normalMenu) {
                IOService.output(on);
            }
        }
        
        String option = IOService.input();
        return option;
    }
}
