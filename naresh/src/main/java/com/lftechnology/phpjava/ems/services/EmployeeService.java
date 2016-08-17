package com.lftechnology.phpjava.ems.services;

import com.lftechnology.phpjava.ems.constants.Constant;
import com.lftechnology.phpjava.ems.dao.EmployeeDaoImpl;
import com.lftechnology.phpjava.ems.dao.UserDaoImpl;
import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.utlis.PasswordHashGenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public void checkAndCreateAdminUser() throws Exception {
        if (!this.checkAdminUserExists()) {
            Employee employee = new Employee();
            employee.setFullname("Admin User")
                    .setAddress("Somewhere")
                    .setRole(Role.ADMIN)
                    .setDepartment("Admin")
                    .setUsername("admin")
                    .setTerminated(false);
            employee.setPassword(PasswordHashGenerator.getSaltedHash("password"));
            insertUserAndEmployee(employee);

        }
    }

    /**
     * check if admin user exists or not
     *
     * @return boolean
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public boolean checkAdminUserExists() throws SQLException {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        List<Employee> employees = employeeDao.findByRole(Role.ADMIN);
        if (employees.isEmpty()) {
            return false;
        }
        Employee employee = employees.get(0);
        Boolean result = (employee.getRole() != null) ? employee.getRole().equals(Role.ADMIN) ? true : false : false;
        return result;
    }


    public int addEmployee(Employee employee) throws Exception {
        employee.setFullname(employee.getFullname().trim());
        employee.setAddress(employee.getAddress().trim());
        employee.setDepartment(employee.getDepartment().trim());
        employee.setUsername(employee.getUsername().trim());
        employee.setPassword(PasswordHashGenerator.getSaltedHash(employee.getPassword()));
        return insertUserAndEmployee(employee);
    }

    private int insertUserAndEmployee(Employee employee) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        int userId = userDao.insert(employee);
        employee.setUserId(userId);
        return employeeDao.insert(employee);
    }

    public int updateEmployee(Employee employee) throws Exception {
        if (employee.getPassword() != null || employee.getUsername() != null) {
            UserDaoImpl userDao = new UserDaoImpl();
            User user = new User();
            user.setUsername(employee.getUsername());
            user.setId(employee.getUserId());
            user.setPassword(PasswordHashGenerator.getSaltedHash(employee.getPassword()));
            return userDao.update(user);
        } else {
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
            return employeeDao.update(employee);
        }
    }

    public List<Employee> searchEmployee(Employee employee) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        if (employee.getDepartment() != null && !employee.getDepartment().isEmpty()) {
            employees = employeeDao.findByDepartment(employee.getDepartment());
        } else if (employee.getFullname() != null && !employee.getFullname().isEmpty()) {
            employees = employeeDao.findByFullName(employee.getFullname());
        } else if (employee.getAddress() != null && !employee.getAddress().isEmpty()) {
            employees = employeeDao.findByAddress(employee.getAddress());
        }
        return employees;
    }

    public int terminateUser(Employee employee) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        Set<Integer> userIds = this.getUserIds(employee);
        return userDao.terminateUsers(userIds);
    }

    public int deleteUser(Employee employee) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        Set<Integer> userIds = this.getUserIds(employee);
        return userDao.delete(userIds);
    }

    private Set<Integer> getUserIds(Employee employee) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        if (employee.getFullname() != null && !employee.getFullname().isEmpty()) {
            employees = employeeDao.findByFullName(employee.getFullname());
        }
        Set<Integer> userIds = employees.stream().map(Employee::getUserId).collect(Collectors.toSet());
        return userIds;
    }


    public String[] getColumns() {
        String[] columnNames = new String[5];
        columnNames[0] = Constant.USER_ID;
        columnNames[1] = Constant.FULL_NAME;
        columnNames[2] = Constant.ADDRESS;
        columnNames[3] = Constant.ROLE_USER_TYPE;
        columnNames[4] = Constant.DEPARTMENT;
        return columnNames;
    }
}
