package com.lftechnology.phpjava.ems.view;

import java.util.Scanner;

import com.lftechnology.phpjava.ems.controller.LoginController;

/**
 * Login view
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com>
 *
 */
public class LoginView {

    /**
     * Provides menu to user to choose from.
     * 
     * @author Bipen Chhetri
     */
    public void loginMenu() {
        System.out.println("Welcome to Emplyment Management System.");
        System.out.println("Please choose the following options:");
        System.out.println("1. Login 2.Any key to exit.");

        validateUserInput();

    }

    /**
     * Validates the user input.
     */
    public void validateUserInput() {
        Scanner userInput = new Scanner(System.in);
        if (userInput.hasNextInt()) {
            Integer choosenInput = userInput.nextInt();
            loginProcess(choosenInput);

        } else {
            System.err.println("Please choose from the options only!");
            loginMenu();
        }
        userInput.close();
    }

    public void loginProcess(Integer input) {
        Scanner userInputs = new Scanner(System.in);
        if (input.equals(1)) {
            System.out.println("Enter Username:");
            String userName = userInputs.nextLine();

            System.out.println("Enter Password");
            String password = userInputs.nextLine();

            LoginController.login(userName, password);

        } else {
            System.out.println("Exiting System....Done");
            System.exit(0);
        }
    }

}
