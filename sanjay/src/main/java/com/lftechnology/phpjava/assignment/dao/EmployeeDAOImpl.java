package com.lftechnology.phpjava.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.lftechnology.phpjava.assignment.entity.Employee;
import com.lftechnology.phpjava.assignment.enums.Roles;
import com.lftechnology.phpjava.assignment.library.DBConnection;
import com.mysql.jdbc.Statement;

/**
 * EmployeeDaoImpl
 *
 * @author Sanjay Shiwakoti<sanjayshiwakoti@lftechnology.com>
 * @since August, 08 2016
 */
public class EmployeeDAOImpl implements DataAccessInterface <Employee>{

    protected Connection conn = DBConnection.getConnection();
    protected PreparedStatement stmt = null;

    @Override
    public List<Employee> findAll() throws SQLException {
        return null;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (fullname, address, department, role) VALUES ( ?, ? , ?, ?);";
        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, employee.getFullname());
        stmt.setString(2, employee.getAddress());
        stmt.setString(3, employee.getDepartment());
        stmt.setString(4, employee.getRole().toString());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }


    @Override
    public int update(Employee employee) throws SQLException {
        String sql = "UPDATE employee set"
                + "fullname = ?,"
                + " address = ?,"
                + " department = ?,"
                + " role=?"
                + "where idemployee =?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFullname());
        stmt.setString(2, employee.getAddress());
        stmt.setString(3, employee.getDepartment());
        stmt.setString(4, employee.getRole().toString());
        stmt.setInt(5, employee.getEmployeeID());
        return stmt.executeUpdate();
    }       
    
    /**
     * Map Employee Data from the result set
     *
     * @author Sanjay Shiwakoti <sanjayshiwakoti@lftechnology.com>
     * @param resultSet
     * @return Employee
     */
    private List<Employee> mapEmployeeData(ResultSet resultSet){
        List<Employee> employees = new ArrayList<>();
        try {
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setAddress(resultSet.getString("address"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setRole(resultSet.getString("role").toLowerCase().equals(Roles.ADMIN.toString().toLowerCase()) ? Roles.ADMIN.toString() : Roles.USER.toString());
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    @SuppressWarnings("unused")
    private List<Employee> find(HashMap<?, ?> filter) throws SQLException {
        String sql = "select * from employee where 1=1 ";
        if(filter.containsKey("role")) {
            sql += " and role = ?";            
        }
        if(filter.containsKey("department")) {
            sql += " and department = ?";            
        }
        if(filter.containsKey("address")) {
            sql += " and address = ?";            
        }
        if(filter.containsKey("fullname")) {
            sql += " and fullname = ?";            
        }
        stmt = conn.prepareStatement(sql);
        if(filter.containsKey("role")) {
            stmt.setString(1, (String) filter.get("role"));
        }        
        if(filter.containsKey("department")) {
            sql += " and department = :department";  
            stmt.setString(2, (String) filter.get("department"));
        }
        if(filter.containsKey("address")) {
            sql += " and address = :address";   
            stmt.setString(3, (String) filter.get("address"));
        }
        if(filter.containsKey("fullname")) {
            sql += " and fullname = :fullname"; 
            stmt.setString(4, (String) filter.get("address"));
        }
        
        ResultSet resultSet = stmt.executeQuery();
        List<Employee> employee = mapEmployeeData(resultSet);
        return employee;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        String sql = "delete from where idemployee=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, employee.getEmployeeID());
        return stmt.executeUpdate();
    }
    
    /**
     * Delete employee by fullname
     * @param employee
     * @return
     * @throws SQLException
     */
    public int deleteEmployeeByFullName(Employee employee) throws SQLException {
        String sql = "delete from where fullname=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFullname());
        return stmt.executeUpdate();
    }
    
    /**
     * Terminate employee By Full Name
     * @param employee
     * @return
     * @throws SQLException
     */
    public int terminateByFullName(Employee employee) throws SQLException {
        String sql = "UPDATE employee set"
                + "is_terminated = 1,"
                + "where fullname =?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFullname());
        return stmt.executeUpdate();
    }
}