package com.lftechnology.appinterfaces;

import com.lftechnology.entities.Employee;
import java.sql.ResultSet;
/**
 * An Interface to define the signatures for the employee management
 * @author achyut
 *
 */
public interface EmployeeInterface {
    
    public boolean isUsernameExists(String username);
    
    public int addEmployee(Employee e);
    
    public int deleteEmployee(Employee e);  
    
    public int terminateEmployee(Employee e);
    
    public Employee editEmployeeDetails(Employee e);
    
    public ResultSet searchEmployee(Employee e); 
    
}
