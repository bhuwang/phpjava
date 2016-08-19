package com.lftechnology.view;

import java.util.Scanner;

import com.lftechnology.controller.UserController;
import com.lftechnology.entities.Employee;
import com.lftechnology.entities.User;
import com.lftechnology.entities.Role;

public class LoginScreen {

    public Employee askForLoginCredential(User user, Scanner scan) {
        UserController lc = new UserController();
        Employee employee = new Employee();
        do {
            System.out.println("\n...Employee Management System...");
            System.out.println("1. Login 2. Any key to exit");
            System.out.println("Enter your choice");
            String choice = scan.nextLine();
            try {
                if ("1".equals(choice)) {

                    String userName = "";
                    String password = "";

                    System.out.println("Enter username::");

                    userName = scan.nextLine();

                    user.setUsername(userName);

                    System.out.println("Enter password::");
                    password = scan.nextLine();
                    user.setPassword(password);

                    lc.login(user, scan);

                } else {
                    employee.setRole(Role.GUEST);
                    System.out.println("Exiting the application.\n\n");

                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (Role.GUEST.equals(employee.getRole())) {
                    scan.close();
                }
            }
        } while (!Role.GUEST.equals(employee.getRole()));

        return employee;
    }
}
