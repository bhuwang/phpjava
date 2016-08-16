package com.lftechnology.phpjava.ems.utlis;

import com.lftechnology.phpjava.ems.constants.Constant;
import com.lftechnology.phpjava.ems.controllers.EmployeeController;
import com.lftechnology.phpjava.ems.controllers.LoginController;
import com.lftechnology.phpjava.ems.services.EmployeeService;
import com.lftechnology.phpjava.ems.views.CommonViewUtility;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * RouterService
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 09 2016
 */
public class Router {

    private static LoginController loginController = new LoginController();
    private static EmployeeController employeeController = new EmployeeController();
    private static CommonUtility commonUtility = new CommonUtility();

    static {
        try {
            onRouteBootstrap();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to be executed on router startup.
     * Will invoke checkAndCreateAdminUser() method
     * to create admin user if the system doesn't have one.
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static void onRouteBootstrap() throws Exception {

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
    public static void showWelcomeScreen() {

        CommonViewUtility.showWelcomeScreen();
    }

    public static void showLoginMenuAndLoginToSystem() {
        if (!commonUtility.getUserService().isUserLoggedIn()) {
            showWelcomeScreen();
            loginController.login();
            commonUtility = (CommonUtility) loginController.getData().get("commonUtility");
        }
    }

    public static void showMenu() {
        showLoginMenuAndLoginToSystem();
        if (!commonUtility.isLoggedIn()) {
            CommonViewUtility.showMessageAndContinue("Invalid Credentails");
        } else {
            Map<String, Object> commonUtilityMap = new HashMap<>();
            commonUtilityMap.put("commonUtility", commonUtility);
            employeeController.setData(commonUtilityMap);
            employeeController.postLoginScreen();
        }
    }


    public static void initiateInitialMenuAction(int menu) {

        if (commonUtility.isAdmin() && menu == Constant.ADD_NEW_USER) {
            employeeController.addUser();
        } else if (commonUtility.isAdmin() && menu == Constant.SEARCH_USER) {
            employeeController.searchUser();
        } else if (commonUtility.isAdmin() && menu == Constant.TERMINATE_USER) {
            employeeController.terminateUser();
        } else if (commonUtility.isAdmin() && menu == Constant.DELETE_USER) {
            employeeController.deleteUser();
        } else if (commonUtility.isUser() && menu == Constant.UPDATE_PROFILE) {
            employeeController.updateProfile();
        } else if (commonUtility.isUser() && menu == Constant.SEARCH_USER) {
            employeeController.searchUser();
        } else if (menu == Constant.EXIT) {
            CommonViewUtility.showExitMessageAndExit();
        } else {
            showMenu();
        }
    }

}
