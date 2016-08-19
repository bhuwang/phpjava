
package com.lftechnology.controller;

import java.sql.ResultSet;
import com.lftechnology.entities.Role;
import com.lftechnology.service.EmployeeService;
import com.lftechnology.service.ServiceFactory;
import com.lftechnology.entities.Employee;

/**
 * Controller to managed the employee
 * @author achyut
 *
 */
public class EmployeeController {

    /**
     * For First time setup on the superadmin
     * @author achyut
     * @return void
     */
    public void prepareInitialUser(){
        EmployeeService ed = ServiceFactory.getEmployeeService();
        if(!ed.isUsernameExists("superadmin")){
            Employee e = new Employee();
            e.setUsername("superadmin");
            e.setPassword("superadmin");
            e.setDepartment("FHF");
            e.setAddress("Kalanki Syuchatar");
            e.setFullName("Achyut Dahal");
            e.setIsTerminated(false);
            e.setRole(Role.ADMIN);
            ed.addEmployee(e);
        }
        
    }
    
    /**
     * Add an employee object to database
     * @param employee
     * @return int
     */
    public int addEmployee(Employee employee) {
        int employeeAdded = 0;
        EmployeeService ed = ServiceFactory.getEmployeeService();
        employeeAdded = ed.addEmployee(employee);

        return employeeAdded;
    }

    /**
     * Terminate an employee
     * @param employee
     * @return int
     */
    public int terminateEmployee(Employee employee) {
        int employeeTerminated = 0;
        EmployeeService emplSerObj = ServiceFactory.getEmployeeService();
        employeeTerminated = emplSerObj.terminateEmployee(employee);        
        return employeeTerminated;
    }
    
    /**
     * Delete an employee from the system
     * @param em
     * @return int
     */
    public int deleteEmployee(Employee employee) {
        int employeeDeleted = 0;
        EmployeeService emplSerObj = ServiceFactory.getEmployeeService();
        employeeDeleted = emplSerObj.deleteEmployee(employee);        
        return employeeDeleted;
    }

    /**
     * View an employee in the system
     * @param employee
     * @return ResultSet
     */
    public ResultSet viewEmployee(Employee employee) {
        ResultSet rs = null;
        EmployeeService emplSerObj = ServiceFactory.getEmployeeService();
        rs = emplSerObj.searchEmployee(employee);
        return rs;
    }

    /**
     * Update the profile of an employee
     * @param employee
     * @return Employee
     */
    public Employee editEmployeeDetails(Employee employee) {
        EmployeeService emplServiceObj = ServiceFactory.getEmployeeService();
        String userNameFormat = "[a-zA-z][a-zA-z0-9._@]+";
        if (employee.getUsername().length() != 0 && !(employee.getUsername().matches(userNameFormat))) {
            System.out.println("\n\t\tUsername Cannot contain extra characters\n");
             return employee;
        }
        return emplServiceObj.editEmployeeDetails(employee);

    }
    
   

}
