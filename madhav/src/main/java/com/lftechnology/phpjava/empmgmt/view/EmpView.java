package main.java.com.lftechnology.phpjava.empmgmt.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class EmpView {
    
    public void list(ResultSet rs) {
        try {
            while(rs.next()) {
                IOService.output(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public String[] add() {
        String[] empData = new String[1];
        IOService.output("Add new user:");
        empData[0] = IOService.input();
        return empData;
    }
    
    public String delete() {
        IOService.output("Enter employee name to delete:");
        String empname = IOService.input();
        return empname;
    }
}
