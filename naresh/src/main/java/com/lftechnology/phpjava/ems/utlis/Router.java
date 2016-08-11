package com.lftechnology.phpjava.ems.utlis;

import com.lftechnology.phpjava.ems.controllers.LoginController;
import com.lftechnology.phpjava.ems.services.EmployeeService;
import com.lftechnology.phpjava.ems.services.UserService;


/**
 * RouterService
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 09 2016
 */
public class Router {

    private static UserService userService = new UserService();

    static {
        onRouteBootstrap();
    }

    /**
     * Method to be executed on router startup.
     * Will invoke checkAndCreateAdminUser() method
     * to create admin user if the system doesn't have one.
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    private static void onRouteBootstrap() {

        SqlRunner sqlRunner = new SqlRunner();
        sqlRunner.executeSql();

        EmployeeService employeeService = new EmployeeService();
        employeeService.checkAndCreateAdminUser();
    }

    /**
     * Show Welcome Screen
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    private static void showWelcomeScreen() {

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Welcome To Employee Management System !!!");

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Enter your credentails to log into the system");
    }

    private static void showLoginMenuAndLoginToSystem() {
        if (!userService.isUserLoggedIn()) {
            showWelcomeScreen();
            LoginController.login();
        }
    }

    private static void showMenu() {
        showLoginMenuAndLoginToSystem();
//        if(userService.isUserLoggedIn() && userService.){
//
//        }

    }

    private static void showAdminMenu() {
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Add New User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Delete User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("3. Search User(s)");
    }

    private static void showNormalUserMenu() {
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Update Profile");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Search User(s)");
    }

    public static void main(String[] args) {
        showMenu();
    }
}
