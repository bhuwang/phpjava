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

    private static CommonUtility commonUtility = new CommonUtility();
    private EmployeeController employeeController = new EmployeeController();
    private String action;

    @Override
    public void render() {
        switch (action) {
            case Constant.POST_LOGIN_ACTION:
                if (this.commonUtility.isLoggedIn() && this.commonUtility.isAdmin()) {
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

    @Override
    public String getAction() {
        return this.action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public Map<String, Object> getData() {
        return null;
    }

    @Override
    public void setData(Map<String, Object> data) {
        commonUtility = (CommonUtility) data.get("commonUtility");
    }

    public void showAdminMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("1. Add New User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Search User(s)");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("3. Terminate User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("4. Delete User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("0. Exit");
        ConsoleWriter.writeBlankLine(5);

        Router.initiateInitialMenuAction(UserInput.getIntegerUserInput());
    }

    public void showNormalUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("1. Update Profile");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Search User(s)");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("0. Exit");
        ConsoleWriter.writeBlankLine(5);

        Router.initiateInitialMenuAction(UserInput.getIntegerUserInput());
    }

    public void showAddUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("Choose One Of The Following User Type");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Add Admin User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Add Normal User");
        ConsoleWriter.writeBlankLine(5);

        Employee employee = new Employee();
        Map<String, Object> postData = new HashMap<>();
        employee.setRole(UserInput.getIntegerUserInput() == 1 ? Role.ADMIN : Role.USER);

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Enter User Details");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Enter Fullname");
        ConsoleWriter.writeBlankLine(5);
        employee.setFullname(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Enter Department");
        ConsoleWriter.writeBlankLine(5);
        employee.setDepartment(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("3. Enter Address");
        ConsoleWriter.writeBlankLine(5);
        employee.setAddress(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("4. Enter Username");
        ConsoleWriter.writeBlankLine(5);
        employee.setUsername(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("5. Enter Password");
        ConsoleWriter.writeBlankLine(5);
        employee.setPassword(UserInput.getStringUserInput());

        postData.put("employee", employee);
        employeeController.setData(postData);

        employeeController.makeCurrentRequestPost();
        employeeController.addUser();

    }

    public void showSearchUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("Choose One Of The Following Search Criteria");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Search By Fullname");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Search By Department");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("3. Search By Address");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("4. Exit");
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Enter search value");
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
            case 4:
                CommonViewUtility.showExitMessageAndExit();
                break;
            default:
                Router.showMenu();
                break;
        }

        Map<String, Object> postData = new HashMap<>();
        postData.put("employee", employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.searchUser();
    }

    public void renderEmployeeList(String[] columns, List<Employee> employees) {
        TableGenerator tableGenerator = new TableGenerator(columns);
        for (Employee employee : employees) {
            tableGenerator.addRow(employee.toArray());
        }
        tableGenerator.renderTable();
    }


    public void showUpdateUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("Update Profile");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Update Fullname");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Update Department");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("3. Update Address");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("4. Update Username");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("5. Update Password");
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();
        ConsoleWriter.writeUserInputRequestMessage("Enter value");
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
        postData.put("employee", employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.updateProfile();
    }

    public void showDeleteUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("Delete User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Enter Fullname of Fullname");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Return to main menu");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("0. Exit");
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();
        Employee employee = new Employee();
        employee = getTerminateAndDeleterUserInput(userInput, employee);
        Map<String, Object> postData = new HashMap<>();
        postData.put("employee", employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.deleteUser();
    }

    public void showTerminateUserMenu() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("Terminate User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Enter Fullname Of User");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. Return to main menu");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("0. Exit");
        ConsoleWriter.writeBlankLine(5);
        int userInput = UserInput.getIntegerUserInput();
        Employee employee = new Employee();
        employee = getTerminateAndDeleterUserInput(userInput, employee);
        Map<String, Object> postData = new HashMap<>();
        postData.put("employee", employee);
        this.employeeController.setData(postData);
        this.employeeController.makeCurrentRequestPost();
        this.employeeController.terminateUser();
    }

    private Employee getTerminateAndDeleterUserInput(int userInput, Employee employee) {
        switch (userInput) {
            case 1:
                ConsoleWriter.writeUserInputRequestMessage("Enter value");
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
