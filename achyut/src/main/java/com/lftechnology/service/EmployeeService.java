
package com.lftechnology.service;

import java.sql.ResultSet;
import com.lftechnology.appinterfaces.EmployeeInterface;
import com.lftechnology.dao.DaoFactory;
import com.lftechnology.dao.EmployeeDao;
import com.lftechnology.entities.Employee;

/**
 * Employee service for communicating the underlying dao
 * @author achyut
 *
 */
public class EmployeeService implements EmployeeInterface {

    /**
     * Check if the username exists on the system
     * @author achyut
     * @param boolean
     */
    @Override
    public boolean isUsernameExists(String username) {
        EmployeeDao ed = DaoFactory.getEmployeeDao();
        return ed.isUsernameExists(username);
    }
    
   /**
    * Adds and employee
    * @author achyut
    * @return int
    */
    @Override
    public int addEmployee(Employee e) {

        int numberOfUserInserted = 0;
        EmployeeDao ed = DaoFactory.getEmployeeDao();

        numberOfUserInserted = ed.addEmployee(e);

        return numberOfUserInserted;
    }

    /**
     * View the employees
     * @author achyut
     * @param ResulSet
     */
   
    @Override
    public ResultSet searchEmployee(Employee e) {

        ResultSet rs = null;

        EmployeeDao ed = DaoFactory.getEmployeeDao();
        rs = ed.searchEmployee(e);

        return rs;
    }

    /**
     * Termniate a user from the system
     * @author achyut
     * @param int
     */
    @Override
    public int terminateEmployee(Employee e) {

        EmployeeDao ed = DaoFactory.getEmployeeDao();
        int numberOfTerminatedUsers = 0;

        numberOfTerminatedUsers = ed.terminateEmployee(e);

        return numberOfTerminatedUsers;

    }
    
    /**
     * Delete an employee from the system
     * @author achyut
     * @param int
     */
    @Override
    public int deleteEmployee(Employee e) {

        EmployeeDao ed = DaoFactory.getEmployeeDao();
        int numberOfTerminatedUsers = 0;

        numberOfTerminatedUsers = ed.deleteEmployee(e);

        return numberOfTerminatedUsers;

    }

    /**
     * Edit an employee profile
     * @author achyut
     * @param Employee
     */
    @Override
    public Employee editEmployeeDetails(Employee employee) {

        EmployeeDao ed = DaoFactory.getEmployeeDao();

        return ed.editEmployeeDetails(employee);
    }


    

}
