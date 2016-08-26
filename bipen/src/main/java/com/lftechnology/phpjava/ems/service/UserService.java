package com.lftechnology.phpjava.ems.service;

import java.sql.SQLException;

import com.lftechnology.phpjava.ems.dao.EmployeeDao;
import com.lftechnology.phpjava.ems.dao.UserDao;
import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.utils.ConsoleWriter;
import com.lftechnology.phpjava.ems.view.LoginView;
import com.lftechnology.phpjava.ems.view.UserView;

/**
 * Service Layer to Validate User and show menus
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com>
 *
 */
public class UserService {
    protected UserView uv = new UserView();
    protected UserDao ud = new UserDao();
    protected EmployeeDao empDoa = new EmployeeDao();

    public void checkDefaultAdminUser() throws Exception {
        int result = ud.checkDefaultUser();
        if (result < 1) {
            Employee emp = new Employee();
            emp.setUsername("admin");
            emp.setPassword("admin");
            emp.setFullName("Administration");
            emp.setDepartment("admin");
            emp.setAddress("Dilllibazar");
            emp.setRole("ADMIN");

            int row = empDoa.insertUserAndEmployee(emp);
            if (row == 1) {
                ConsoleWriter.setMessageToConsole("Default admin user created automatically. Login with admin/admin");
            }
        }
    }

    public void validateUser(String username, String password) throws Exception {
        Employee emp = ud.validateUser(username, password);

        if (emp.getId() == 0) {
            LoginView lv = new LoginView();
            ConsoleWriter.setErrorMessageToConsole("User doesnot exist!! Please Try again");
            ConsoleWriter.setPrintBlankLines(1);
            lv.loginProcess(1);

        } else {
            System.out.format("Welcome %s ", emp.getUsername());
            ConsoleWriter.setMessageToConsole(emp.getRole());
            if (emp.getRole().equals(Role.ADMIN.toString())) {
                uv.getAdminUserMenu();
            } else {
                uv.getNormalUserMenu();
            }
        }
    }

    /**
     * Routes user choose option to corresponding user's method.
     * 
     * @author bipen
     */
    public void routeOptionToMethod(int input) throws Exception {
        switch (input) {
        case 1:
            this.addUser();
            break;
        case 2:
            this.deleteUser();
            break;
        case 3:
            this.terminateUser();
            break;
        case 4:
            this.searchUser();
            break;
        default:
            ConsoleWriter.setErrorMessageToConsole("Option is not available. Please choose again.");
            uv.getAdminUserMenu();
            break;
        }

    }

    public void addUser() throws Exception {
        Integer ip = uv.addUserMenu();
        switch (ip) {
        case 1:
            this.addUserForm(Role.ADMIN);
            break;
        case 2:
            this.addUserForm(Role.NORMAL);
            break;
        default:
            ConsoleWriter.setErrorMessageToConsole("Invalid option. please try again");
            ConsoleWriter.setPrintBlankLines(1);
            addUser();
        }

    }

    public void addUserForm(Role role) throws SQLException {
        Employee emp = new Employee();
        emp.setRole(role.toString());
        emp = uv.addUserForm(emp);

        ConsoleWriter.setMessageToConsole("Return : " + empDoa.insertUserAndEmployee(emp));

    }

    public void createUser(Role role) {
        Employee employee = new Employee();
        employee.setUsername("");

    }

    public void deleteUser() {
        ConsoleWriter.setMessageToConsole("deleteUser");
    }

    public void terminateUser() {
        ConsoleWriter.setMessageToConsole("Terminate user");
    }

    public void searchUser() {
        ConsoleWriter.setMessageToConsole("search user");
    }
}
