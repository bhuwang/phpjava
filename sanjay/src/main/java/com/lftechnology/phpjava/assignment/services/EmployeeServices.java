package com.lftechnology.phpjava.assignment.services;

import java.sql.SQLException;
import java.util.HashMap;

import com.lftechnology.phpjava.assignment.constant.EmployeeConstant;
import com.lftechnology.phpjava.assignment.constant.UserConstant;
import com.lftechnology.phpjava.assignment.dao.EmployeeDAOImpl;
import com.lftechnology.phpjava.assignment.dao.UserDaoImpl;
import com.lftechnology.phpjava.assignment.entity.Employee;
import com.lftechnology.phpjava.assignment.entity.User;

public class EmployeeServices {
    
    public boolean createEmployeeRecord(HashMap<?,?> empl) {
        Employee employee = new Employee();
        employee.setFullname(empl.get(EmployeeConstant.EMP_FULLNAME).toString());
        employee.setAddress(empl.get(EmployeeConstant.EMP_ADDRESS).toString());
        employee.setRole(empl.get(EmployeeConstant.EMP_ROLE).toString());
        employee.setDepartment(empl.get(EmployeeConstant.EMP_DEPARTMENT).toString());
                
        User user = new User();
        user.setTerminated((boolean) empl.get(UserConstant.USR_TERMINATED));
        user.setUsername(empl.get(UserConstant.USR_NAME).toString());
        user.setPassword(empl.get(UserConstant.USR_PASSWORD).toString());
                
        try {
            UserDaoImpl userDao = new UserDaoImpl();
            EmployeeDAOImpl employeeDao = new EmployeeDAOImpl();
            employeeDao.insert(employee);
            userDao.insert(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }                
        return false;        
    }
    
    public boolean checkUserExists(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.findValidUser(user);
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }                
        return false;        
    }
}
