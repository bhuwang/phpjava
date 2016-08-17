package com.lftechnology.phpjava.ems.views;

import com.lftechnology.phpjava.ems.constants.Constant;
import com.lftechnology.phpjava.ems.controllers.EmployeeController;
import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.utlis.CommonUtility;
import com.lftechnology.phpjava.ems.utlis.ConsoleWriter;
import com.lftechnology.phpjava.ems.utlis.Router;
import com.lftechnology.phpjava.ems.utlis.UserInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EmployeeView
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 16 2016
 */
public class EmployeeView implements ViewSignature<Object> {
    public static CommonUtility commonUtility = new CommonUtility();
    private EmployeeController employeeController = new EmployeeController();
    private String action;

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public void render() {
        switch (action) {
            case Constant.POST_LOGIN_ACTION:
                if (commonUtility.isLoggedIn() && commonUtility.isAdmin()) {
                    this.showAdminMenu();
                } else {
                    this.showNormalUserMenu();
                }
                break;
            case Constant.ADD_USER_ACTION:
                this.showAddUserMenu();
                break;
            case Constant.DELETE_USER_ACTION:
                this.showDeleteUserMenu();
                break;
            case Constant.SEARCH_USER_ACTION:
                this.showSearchUserMenu();
                break;
            case Constant.TERMINATE_USER_ACTION:
                this.showTerminateUserMenu();
                break;
            case Constant.UPDATE_PROFILE_ACTION:
                this.showUpdateUserMenu();
                break;
            case Constant.EXIT_ACTION:
                CommonViewUtility.showExitMessageAndExit();
                break;
            default:
                Router.showMenu();
        }
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public String getAction() {
        return this.action;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public Map<String, Object> getData() {
        return null;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public void setData(Map<String, Object> data) {
        commonUtility = (CommonUtility) data.get(Constant.COMMON_UTILITY);
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void showAdminMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ADD_NEW_USER_MESSAGE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.SEARCH_USERS);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.TERMINATE_USER_MESSAGE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.DELETE_USER_MESSAGE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.EXIT_MESSAGE);
        ConsoleWriter.writeBlankLine(5);

        Router.initiateInitialMenuAction(UserInput.getIntegerUserInput());
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void showNormalUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.UPDATE_PROFILE_MESSAGE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.SEARCH_USERS);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.EXIT_MESSAGE);
        ConsoleWriter.writeBlankLine(5);

        Router.initiateInitialMenuAction(UserInput.getIntegerUserInput());
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void showAddUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.CHOOSE_ONE_OF_THE_FOLLOWING_USER_TYPE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ADD_ADMIN_USER);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ADD_NORMAL_USER);
        ConsoleWriter.writeBlankLine(5);

        Employee employee = new Employee();
        Map<String, Object> postData = new HashMap<>();
        employee.setRole(UserInput.getIntegerUserInput() == 1 ? Role.ADMIN : Role.USER);

        employee = showAddUserMenu(employee);

        postData.put(Constant.EMPLOYEE, employee);
        employeeController.setData(postData);

        employeeController.makeCurrentRequestPost();
        employeeController.addUser();

    }

    /**
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param employee
     * @return
     */
    private Employee showAddUserMenu(Employee employee) {
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_USER_DETAILS);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_FULLNAME);
        ConsoleWriter.writeBlankLine(5);
        employee.setFullname(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_DEPARTMENT);
        ConsoleWriter.writeBlankLine(5);
        employee.setDepartment(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_ADDRESS);
        ConsoleWriter.writeBlankLine(5);
        employee.setAddress(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_USERNAME);
        ConsoleWriter.writeBlankLine(5);
        employee.setUsername(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_PASSWORD);
        ConsoleWriter.writeBlankLine(5);
        employee.setPassword(UserInput.getStringUserInput());

        return employee;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void showSearchUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.CHOOSE_ONE_OF_THE_FOLLOWING_SEARCH_CRITERIA);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.SEARCH_BY_FULLNAME);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.SEARCH_BY_DEPARTMENT);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.SEARCH_BY_ADDRESS);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.EXIT_MESSAGE);
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_SEARCH_VALUE);
        String searchValue = UserInput.getStringUserInput();

        Employee employee = new Employee();
        switch (userInput) {
            case 1:
                employee.setFullname(searchValue);
                break;
            case 2:
                employee.setDepartment(searchValue);
                break;
            case 3:
                employee.setAddress(searchValue);
                break;
            case 0:
                CommonViewUtility.showExitMessageAndExit();
                break;
            default:
                Router.showMenu();
                break;
        }

        Map<String, Object> postData = new HashMap<>();
        postData.put(Constant.EMPLOYEE, employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.searchUser();
    }

    /**
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param columns
     * @param employees
     */
    public void renderEmployeeList(String[] columns, List<Employee> employees) {
        TableGenerator tableGenerator = new TableGenerator(columns);
        for (Employee employee : employees) {
            tableGenerator.addRow(employee.toArray());
        }
        tableGenerator.renderTable();
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void showUpdateUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.UPDATE_PROFILE_MENU);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.UPDATE_FULLNAME);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.UPDATE_DEPARTMENT);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.UPDATE_ADDRESS);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.UPDATE_USERNAME);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.UPDATE_PASSWORD);
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_VALUE);
        String value = UserInput.getStringUserInput();
        Employee employee = new Employee();
        employee.setUserId(commonUtility.getUserService().getUserId());
        switch (userInput) {
            case 1:
                employee.setFullname(value);
                break;
            case 2:
                employee.setDepartment(value);
                break;
            case 3:
                employee.setAddress(value);
                break;
            case 4:
                employee.setUsername(value);
                break;
            case 5:
                employee.setPassword(value);
                break;
            case 6:
                CommonViewUtility.showExitMessageAndExit();
                break;
            default:
                Router.showMenu();
                break;
        }
        Map<String, Object> postData = new HashMap<>();
        postData.put(Constant.EMPLOYEE, employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.updateProfile();
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void showDeleteUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.DELETE_USER_MENU);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_FULLNAME_OF_EMPLOYEE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.RETURN_TO_MAIN_MENU);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.EXIT_MESSAGE);
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();
        Employee employee = new Employee();
        employee = getTerminateAndDeleterUserInput(userInput, employee);
        Map<String, Object> postData = new HashMap<>();
        postData.put(Constant.EMPLOYEE, employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.deleteUser();
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void showTerminateUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.TERMINATE_USER_MENU);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_FULLNAME_OF_EMPLOYEE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.RETURN_TO_MAIN_MENU);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.EXIT_MESSAGE);
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();
        Employee employee = new Employee();
        employee = getTerminateAndDeleterUserInput(userInput, employee);
        Map<String, Object> postData = new HashMap<>();
        postData.put(Constant.EMPLOYEE, employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.terminateUser();
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param userInput
     * @param employee
     * @return
     */
    private Employee getTerminateAndDeleterUserInput(int userInput, Employee employee) {
        switch (userInput) {
            case 1:
                ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_VALUE);
                String value = UserInput.getStringUserInput();
                employee.setFullname(value);
                break;
            case 2:
                CommonViewUtility.showExitMessageAndExit();
                break;
            default:
                Router.showMenu();
                break;
        }
        return employee;
    }
}
