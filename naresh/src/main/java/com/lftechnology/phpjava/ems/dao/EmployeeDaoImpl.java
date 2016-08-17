package com.lftechnology.phpjava.ems.dao;

import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.utlis.DbFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeDaoImpl
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class EmployeeDaoImpl implements DaoSignature<Employee> {

    protected Connection conn = DbFactory.getConnection();
    protected PreparedStatement stmt = null;

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     * @throws SQLException
     */
    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee e INNER JOIN user u ON e.user_id = u.id WHERE u.is_terminated = 0";
        stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            Employee employee = new Employee();
            employee.setFullname(result.getString("fullname"));
            employee.setAddress(result.getString("address"));
            employee.setDepartment(result.getString("department"));
            employee.setRole(result.getString("role").equals(Role.ADMIN.toString()) ? Role.ADMIN : Role.USER);
            employee.setUserId(result.getInt("user_id"));
            employee.setUsername(result.getString("username"));
            employees.add(employee);
            System.out.println(employee.toString());
        }
        return employees;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param employee
     * @return
     * @throws SQLException
     */
    @Override
    public int insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (fullname, address, department, role, user_id) VALUES ( ?, ? , ?, ?,?);";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFullname());
        stmt.setString(2, employee.getAddress());
        stmt.setString(3, employee.getDepartment());
        stmt.setString(4, employee.getRole().toString());
        stmt.setInt(5, employee.getUserId());
        return stmt.executeUpdate();
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param employee
     * @return
     * @throws SQLException
     */
    @Override
    public int update(Employee employee) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE employee SET");
        boolean update = false;
        String value = "";
        if (employee.getFullname() != null && !employee.getFullname().isEmpty()) {
            update = true;
            value = employee.getFullname();
            sql.append(" fullname = ?");
        } else if (employee.getAddress() != null && !employee.getAddress().isEmpty()) {
            update = true;
            value = employee.getAddress();
            sql.append(" address = ?");
        } else if (employee.getDepartment() != null && !employee.getDepartment().isEmpty()) {
            update = true;
            value = employee.getDepartment();
            sql.append(" department = ?");
        }
        if (update) {
            sql.append(" WHERE user_id = ? ");
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, value);
            stmt.setInt(2, employee.getUserId());
            return stmt.executeUpdate();
        }
        return 0;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param employee
     * @return
     * @throws SQLException
     */
    @Override
    public int delete(Employee employee) throws SQLException {
        return 0;
    }


    /**
     * Find the employee by fullname
     *
     * @param fullName
     * @return Employee
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public List<Employee> findByFullName(String fullName) throws SQLException {

        String sql = "SELECT * FROM employee WHERE fullname = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fullName);
        return findBy(stmt);
    }

    /**
     * Find the employee by address
     *
     * @param address
     * @return Employee
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public List<Employee> findByAddress(String address) throws SQLException {

        String sql = "SELECT * FROM employee WHERE address = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, address);
        return findBy(stmt);
    }

    /**
     * Find the employee by department
     *
     * @param department
     * @return Employee
     * @throws SQLException
     */

    public List<Employee> findByDepartment(String department) throws SQLException {

        String sql = "SELECT * FROM employee WHERE department = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, department);
        return findBy(stmt);
    }

    /**
     * Find the employee by role
     *
     * @param
     * @return Employee
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */

    public List<Employee> findByRole(Role role) throws SQLException {

        String sql = "SELECT * FROM employee WHERE role = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, role.toString());
        return findBy(stmt);
    }

    /**
     * Find the employee by role
     *
     * @param
     * @return Employee
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */

    public List<Employee> findByUserId(int userId) throws SQLException {

        String sql = "SELECT * FROM employee WHERE user_id = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        return findBy(stmt);
    }


    /**
     * @param stmt
     * @return Employee
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    private List<Employee> findBy(PreparedStatement stmt) throws SQLException {
        ResultSet resultSet = stmt.executeQuery();
        List<Employee> employees = setEmployeeData(resultSet);
        return employees;
    }


    /**
     * set employee data from the resultset
     *
     * @param resultSet
     * @return Employee
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    private List<Employee> setEmployeeData(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setAddress(resultSet.getString("address"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setFullname(resultSet.getString("fullname"));
            employee.setRole((resultSet.getString("role")).equals(Role.ADMIN.toString()) ? Role.ADMIN : Role.USER);
            employee.setUserId(resultSet.getInt("user_id"));
            employees.add(employee);
        }
        return employees;
    }

}
