package com.lftechnology.phpjava.ems.dao;

import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.utlis.DbFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * EmployeeDaoImpl
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class EmployeeDaoImpl implements DaoSignature <Employee>{

    protected Connection conn = DbFactory.getConnection();
    protected PreparedStatement stmt = null;

    @Override
    public List<Employee> findAll() throws SQLException {
        return null;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (fullname, address, department, role) VALUES ( ?, ? , ?, ?);";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFullname());
        stmt.setString(2, employee.getAddress());
        stmt.setString(3, employee.getDepartment());
        stmt.setString(4, employee.getRole().toString());
        return stmt.executeUpdate();
    }

    @Override
    public int update(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public boolean delete(Employee employee) throws SQLException {
        return false;
    }


    /**
     * Find the employee by fullname
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param fullName
     * @return Employee
     * @throws SQLException
     */
    public Employee findByFullName(String fullName) throws SQLException {

        String sql = "SELECT * FROM employee WHERE fullname = ?";

        return findBy(sql, fullName);
    }

    /**
     * Find the employee by address
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param address
     * @return Employee
     * @throws SQLException
     */
    public Employee findByAddress(String address) throws SQLException {

        String sql = "SELECT * FROM employee WHERE address = ?";

        return findBy(sql, address);
    }

    /**
     * Find the employee by department
     *
     * @param department
     * @return Employee
     * @throws SQLException
     */

    public Employee findByDepartment(String department) throws SQLException {

        String sql = "SELECT * FROM employee WHERE department = ?";

        return findBy(sql, department);
    }

    /**
     * Find the employee by role
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param
     * @return Employee
     * @throws SQLException
     */

    public Employee findByRole(Role role) throws SQLException {

        String sql = "SELECT * FROM employee WHERE role = ?";

        return findBy(sql, role.toString());
    }



    /**
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param sql
     * @param bindValue
     * @return Employee
     */
    private Employee findBy(String sql, String bindValue){
        Employee employee = new Employee();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bindValue);
            ResultSet resultSet = stmt.executeQuery();
            employee = setEmployeeData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbFactory.closeConnection();
        }
        return employee;
    }

    /**
     * set employee data from the resultset
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param resultSet
     * @return Employee
     */
    private Employee setEmployeeData(ResultSet resultSet){
        Employee employee = new Employee();
        try {
            if (resultSet.next()) {
                employee.setAddress(resultSet.getString("address"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setRole((resultSet.getString("role").toLowerCase()).equals(Role.ADMIN.toString()) ? Role.ADMIN :Role.USER);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
