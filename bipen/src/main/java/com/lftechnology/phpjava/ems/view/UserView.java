package com.lftechnology.phpjava.ems.view;

import java.util.Scanner;

import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.service.UserService;
import com.lftechnology.phpjava.ems.utils.ConsoleWriter;

public class UserView {

    /**
     * @author bipen
     * @throws Exception
     */
    public void getAdminUserMenu() throws Exception {

        ConsoleWriter.setMessageToConsole("Please Choose from following options:");
        ConsoleWriter.setMessageToConsole("1. Add User");
        ConsoleWriter.setMessageToConsole("2. Delete User");
        ConsoleWriter.setMessageToConsole("3. Terminate User");
        ConsoleWriter.setMessageToConsole("4. Search User");
        Integer userInput = ConsoleWriter.getUserInput();
        UserService us = new UserService();
        us.routeOptionToMethod(userInput);

    }

    /**
     * @author bipen
     */
    public void getNormalUserMenu() {
        ConsoleWriter.setMessageToConsole("Please Choose from following options:");
        ConsoleWriter.setMessageToConsole("1. Update Profile");
        ConsoleWriter.setMessageToConsole("2. Search Employee");
    }

    /**
     * 
     */
    public Integer addUserMenu() {
        ConsoleWriter.setMessageToConsole("Choose option");
        ConsoleWriter.setMessageToConsole("1. Admin User");
        ConsoleWriter.setMessageToConsole("2. Normal User");
        Integer ip = ConsoleWriter.getUserInput();
        return ip;
    }

    public Employee addUserForm(Employee emp) {
        Scanner userInputs = new Scanner(System.in);
        ConsoleWriter.setMessageToConsole("Enter Username:");
        String userName = userInputs.nextLine();
        emp.setUsername(userName);
        ConsoleWriter.setMessageToConsole("Enter Password:");
        String password = userInputs.nextLine();
        emp.setPassword(password);
        ConsoleWriter.setMessageToConsole("Address :");
        String address = userInputs.nextLine();
        emp.setAddress(address);
        ConsoleWriter.setMessageToConsole("Department :");
        String department = userInputs.nextLine();
        emp.setDepartment(department);
        ConsoleWriter.setMessageToConsole("Fullname :");
        String fullName = userInputs.nextLine();
        emp.setFullName(fullName);

        userInputs.close();
        return emp;

    }

}
