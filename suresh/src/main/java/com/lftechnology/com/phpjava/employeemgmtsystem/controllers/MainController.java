package com.lftechnology.com.phpjava.employeemgmtsystem.controllers;

import java.sql.SQLException;
import java.util.Scanner;

import com.lftechnology.com.phpjava.employeemgmtsystem.entities.Employee;
import com.lftechnology.com.phpjava.employeemgmtsystem.services.EmployeeService;

public class MainController {

    EmployeeService employeeService = new EmployeeService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Employee employeeLogged = new Employee();

        MainController mainController = new MainController();

        try {
            Employee employee = new Employee();
            employee = mainController.employeeService.checkIfAdminAlreadyExists();

            System.out.println("hello");

            if (employee == null) {
                System.out.println("No Admin registered.");
                employee = mainController.userForm();
                mainController.employeeService.createAdmin(employee);
            } else {
                System.out.println("Admin Exists.");
            }

            mainController.employeeService.createAdmin(employee);

        } catch (Exception exp) {
            System.out.println("Error occured.");
            exp.printStackTrace();
        }

        try {
            // Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            employeeLogged = mainController.employeeService.login(username, password);
            if (employeeLogged != null) {
                System.out.println("Hello " + employeeLogged.getFullname());
                System.out.println("Your role set as " + employeeLogged.getRole());
            } else {
                System.out.println("Incorrect username or password. Please try again.");
            }
        } catch (SQLException exp) {
            // TODO Auto-generated catch block
            System.out.println("User or Password is incorrect.");
            exp.printStackTrace();
        }

    }

    public Employee userForm() {
        Employee employee = new Employee();

        System.out.println("Enter username: ");
        employee.setUsername(scanner.nextLine());
        System.out.println("Enter password: ");
        employee.setPassword(scanner.nextLine());
        System.out.println("Enter fullname: ");
        employee.setFullname(scanner.nextLine());
        System.out.println("Enter department: ");
        employee.setDepartment(scanner.nextLine());
        System.out.println("Enter address: ");
        employee.setAddress(scanner.nextLine());
        System.out.println("Enter role: ");
        employee.setRole(scanner.nextLine());

        return employee;
    }

}
