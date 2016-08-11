package com.lftechnology.phpjava.ems.services;

import com.lftechnology.phpjava.ems.dao.EmployeeDaoImpl;
import com.lftechnology.phpjava.ems.dao.UserDaoImpl;
import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.utlis.PasswordHashGenerator;

import java.sql.SQLException;

/**
 * EmployeeService
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 09 2016
 */
public class EmployeeService {

    /**
     * check if admin user exists or not and create a new one if it doesn't
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void checkAndCreateAdminUser(){
        if(!this.checkAdminUserExists()){
            Employee employee = new Employee();
            employee.setFullname("Admin User");
            employee.setAddress("Somewhere");
            employee.setRole(Role.ADMIN);
            employee.setDepartment("Admin");
            employee.setUsername("admin");
            employee.setTerminated(false);
            try {
                employee.setPassword(PasswordHashGenerator.getSaltedHash("password"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            UserDaoImpl userDao = new UserDaoImpl();
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
            try {
                int userId = userDao.insert(employee);
                employee.setUserId(userId);
                employeeDao.insert(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * check if admin user exists or not
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return boolean
     */
    public boolean checkAdminUserExists() {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Boolean result = false;
        try {
            Employee employee = employeeDao.findByRole(Role.ADMIN);
            result = (employee.getRole() != null) ? employee.getRole().equals(Role.ADMIN) ? true : false : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
