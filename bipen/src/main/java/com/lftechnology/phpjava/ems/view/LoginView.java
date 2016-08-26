package com.lftechnology.phpjava.ems.view;

import java.util.Scanner;

import com.lftechnology.phpjava.ems.controller.LoginController;
import com.lftechnology.phpjava.ems.utils.ConsoleWriter;

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
        ConsoleWriter.setMessageToConsole("Welcome to Emplyment Management System.");
        ConsoleWriter.setMessageToConsole("Please choose the following options:");
        ConsoleWriter.setMessageToConsole("1. Login 2.Any key to exit.");

        validateUserInput();

    }

    /**
     * Validates the user input.
     */
    public void validateUserInput() {
        Integer i = ConsoleWriter.getUserInput();
        if (i > 0) {
            this.loginProcess(i);
        } else {
            this.loginMenu();
        }
    }

    public void loginProcess(Integer input) {
        if (input.equals(1)) {
            LoginController.createDefaultAdminUser();
            Scanner userInputs = new Scanner(System.in);
            ConsoleWriter.setMessageToConsole("Enter Username:");
            String userName = userInputs.nextLine();

            ConsoleWriter.setMessageToConsole("Enter Password");
            String password = userInputs.nextLine();
            LoginController.login(userName, password);

        } else if (input.equals(2)) {
            ConsoleWriter.setErrorMessageToConsole("Exiting System....Done");
            ConsoleWriter.setPrintBlankLines(1);
            System.exit(0);
        } else {
            ConsoleWriter.setErrorMessageToConsole("Improper option. Please choose again.");
            ConsoleWriter.setPrintBlankLines(2);
            this.loginMenu();
        }
    }

}
