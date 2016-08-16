package com.lftechnology.phpjava.ems.services;

import com.lftechnology.phpjava.ems.dao.EmployeeDaoImpl;
import com.lftechnology.phpjava.ems.dao.UserDaoImpl;
import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * UserService
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 09 2016
 */
public class UserService {

    UserDaoImpl userDao = new UserDaoImpl();
    private boolean isLoggedIn = false;
    private String loggedInUserRole = "";
    private int userId;

    public void login(User user) {
        try {
            User result = userDao.findByUsernamePassword(user);
            if (user.getUsername().equals(result.getUsername())) {
                this.isLoggedIn = true;
                this.userId = result.getId();
                EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
                List<Employee> employees = employeeDao.findByUserId(this.userId);
                Employee employee = employees.get(0);
                this.loggedInUserRole = employee.getRole().toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserLoggedIn() {
        return this.isLoggedIn;
    }

    public String getLoggedInUserRole() {
        return this.loggedInUserRole;
    }

    public int getUserId() {
        return this.userId;
    }

    public void logout() {
        this.isLoggedIn = false;
    }
}
