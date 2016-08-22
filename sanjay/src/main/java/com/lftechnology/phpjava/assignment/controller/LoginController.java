package com.lftechnology.phpjava.assignment.controller;

import com.lftechnology.phpjava.assignment.entity.User;
import com.lftechnology.phpjava.assignment.library.ConsoleUtil;
import com.lftechnology.phpjava.assignment.services.EmployeeServices;

public class LoginController {
    private static EmployeeServices employeeService = new EmployeeServices();
    public static void loginMenuController() {
        User user = new User();
        ConsoleUtil.consoleWrite("Enter your username:");
        user.setUsername(ConsoleUtil.gerUserInput());
        ConsoleUtil.consoleWrite("Enter your password:");
        user.setPassword(ConsoleUtil.gerUserInput());          
    }
    
    public static void generateAdminLoggedInMenuController() {
        ConsoleUtil.consoleWrite("Input for Following");
        ConsoleUtil.consoleWrite("1 Add User");
        ConsoleUtil.consoleWrite("2 Delete User");
        ConsoleUtil.consoleWrite("3 Terminate User");
        ConsoleUtil.consoleWrite("4 Seach User");
        String inputScan = ConsoleUtil.gerUserInput();
        if(inputScan.equals(1)) {
            //Call Create Employee Service
        } else if (inputScan.equals(2)) {
            //Delete User Service
        } else if(inputScan.equals(3)) {
            //Terminate User
        } else if (inputScan.equals(4)) {
            //Search with view
        }
    }
    
    public static void generateNormalLoggedInMenuController() {
        ConsoleUtil.consoleWrite("Input for Following");
        ConsoleUtil.consoleWrite("1 Update Information");
        ConsoleUtil.consoleWrite("2 Search Employee");
        String inputScan = ConsoleUtil.gerUserInput();
        if(inputScan.equals(1)) {
            //Update Information
        } else if (inputScan.equals(2)) {
            //Search Employee
        } 
        
    }
    
    
    public static void generateUpdateInfoMenuController() {
        ConsoleUtil.consoleWrite("Input for Following");
        ConsoleUtil.consoleWrite("1 Update Fullname");
        ConsoleUtil.consoleWrite("2 Update department");
        ConsoleUtil.consoleWrite("3 Address");
        String inputScan = ConsoleUtil.gerUserInput();
        if(inputScan.equals(1)) {
            //Update Full name
        } else if (inputScan.equals(2)) {
            //Update Department
        } else if (inputScan.equals(3)) {
            //Update Address
        } 
    }
}
