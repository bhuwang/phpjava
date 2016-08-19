package com.lftechnology.com.phpjava.employeemgmtsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lftechnology.com.phpjava.employeemgmtsystem.entities.Employee;
import com.lftechnology.com.phpjava.employeemgmtsystem.utilities.DBConnection;

public class EmployeeDao {

    public void addUser(Employee employee) {

        Connection connection = DBConnection.getMYSQLConn();
        try {
            String queryUser = "INSERT INTO user (username, password, is_terminated) values(?, ?, ?)";
            PreparedStatement prepStmt = connection.prepareStatement(queryUser);
            prepStmt.setString(1, employee.getUsername());
            prepStmt.setString(2, employee.getPassword());
            prepStmt.setBoolean(3, false);
            prepStmt.execute();

            String queryEmployee = "INSERT INTO employee (fullname, department, address, role, user_id) values( ?, ?, ?, ?, ?)";
            PreparedStatement prepStmtEmployee = connection.prepareStatement(queryEmployee);
            prepStmtEmployee.setString(1, employee.getFullname());
            prepStmtEmployee.setString(2, employee.getDepartment());
            prepStmtEmployee.setString(3, employee.getAddress());
            prepStmtEmployee.setString(4, employee.getRole());
            // TODO:: Get user id
            prepStmtEmployee.setString(5, "1");

            prepStmtEmployee.execute();
            System.out.println("Added user successfully.");
        } catch (Exception exp) {
            System.out.println("Error occured.");
            exp.printStackTrace();
        }

    }

    public Employee login(String username, String password) {

        Connection connection = DBConnection.getMYSQLConn();
        Employee emp = null;
        try {
            String query =
                    "SELECT * FROM user JOIN employee ON user_id = iduser WHERE username = ? AND password = ? AND is_terminated = FALSE";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                emp = new Employee();
                emp.setId(result.getInt("iduser"));
                emp.setUsername(result.getString("username"));
                emp.setPassword(result.getString("password"));
                emp.setFullname(result.getString("fullname"));
                emp.setAddress(result.getString("address"));
                emp.setDepartment(result.getString("department"));
                emp.setIsTerminated(result.getBoolean("is_terminated"));
                emp.setRole(result.getString("role"));
            }
        } catch (Exception exp) {
            System.out.println("Error occured.");
            exp.printStackTrace();
        }
        return emp;
    }

    public Employee checkIfAdminAlreadyExists() throws SQLException {
        // System.out.println("Hello Employee Dao");
        Connection connection = DBConnection.getMYSQLConn();
        String query = "SELECT * FROM user JOIN employee ON user_id = iduser WHERE role = 'admin' AND is_terminated = false;";

        PreparedStatement prepStmt = connection.prepareStatement(query);

        // prepStmt.setString(1, "admin");
        // prepStmt.setBoolean(2, false);

        ResultSet result = prepStmt.executeQuery(query);

        System.out.println("Hello Employee Dao2");
        Employee emp = null;

        System.out.println(result);

        while (result.next()) {
            emp = new Employee();
            emp.setId(result.getInt("iduser"));
            emp.setUsername(result.getString("username"));
            emp.setPassword(result.getString("password"));
            // emp.setFullname(result.getString("fullname"));
            // emp.setAddress(result.getString("address"));
            // emp.setDepartment(result.getString("department"));
            // emp.setIsTerminated(result.getBoolean("is_terminated"));
            // emp.setRole(result.getString("role"));
        }
        return emp;
    }

}
