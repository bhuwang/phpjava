package main.java.com.lftechnology.phpjava.empmgmt.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.lftechnology.phpjava.empmgmt.dao.EmpDao;

public class EmpService {
    public ResultSet listEmployees() {
        EmpDao ed = new EmpDao();
        return ed.listEmployees();
    }

    public void addEmployee(String[] empData) {
        EmpDao ed = new EmpDao();

        ResultSet checkExisting = ed.getEmployeeByName(empData[0]);
        try {
            if (checkExisting.next()) {
                throw new Exception("Employee already exists");
            }
            ed.addEmployee(empData);
            IOService.output("Employee " + empData[0] + " added successfully.");
        } catch (SQLException ex) {
            IOService.output(ex.getMessage());
        } catch (Exception ex) {
            IOService.output(ex.getMessage());
        }
    }

    public void deleteEmployee(String empname) {
        EmpDao ed = new EmpDao();

        ResultSet checkExisting = ed.getEmployeeByName(empname);
        try {
            if (!checkExisting.next()) {
                throw new Exception("Employee " + empname + " does not exists");
            }
            ed.deleteEmployee(empname);
            IOService.output("Employee " + empname + " deleted successfully.");
        } catch (SQLException ex) {
            IOService.output(ex.getMessage());
        } catch (Exception ex) {
            IOService.output(ex.getMessage());
        }
    }
}