package com.lftechnology.com.phpjava.employeemgmtsystem.services;

import java.sql.SQLException;

import com.lftechnology.com.phpjava.employeemgmtsystem.DAO.EmployeeDao;
import com.lftechnology.com.phpjava.employeemgmtsystem.entities.Employee;

public class EmployeeService {

    public void addUser(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.addUser(employee);
    }

    public Employee login(String username, String password) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.login(username, password);
    }

    public Employee checkIfAdminAlreadyExists() throws SQLException {
        // System.out.println("hello employee service.");
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.checkIfAdminAlreadyExists();
    }

    public void createAdmin(Employee employee) throws SQLException {
        addUser(employee);
    }

}
