package com.lftechnology.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.lftechnology.entities.Employee;
import com.lftechnology.entities.Role;

import com.lftechnology.controller.EmployeeController;


public class EmployeeView {

    /**
     * Add Employee 
     * @author achyut
     * @param employee
     * @param sc
     * @return void
     */
    public void addEmployee(Employee employee, Scanner scan) {
        String userName = null;
        String password = null;
        String fullName = null;
        String department = null;
        String address = null;
        int count = 0;
        boolean isTerminated = false;
        Role role = null;

        for (;;) {
            try {
                System.out.println("\nPlease enter the employee username");
                userName = scan.nextLine();
                System.out.println("Pleasse enter the password for the password");                
                password = scan.nextLine();
                System.out.println("please enter the fullname");
                fullName = scan.nextLine();
                System.out.println("Please enter the department");
                department = scan.nextLine();
                System.out.println("Please enter the address");
                address = scan.nextLine();
                System.out.println("Please enter whether the user is terminated(true/false)");
                isTerminated = scan.nextBoolean();
                System.out.println("Please enter the user type::(1=ADMIN/2=EMPLOYEE)");
                int role2 = scan.nextInt();
                if (role2 == 1) {
                    role = Role.ADMIN;
                } else if (role2 == 2) {
                    role = Role.USER;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Error Occured:"+ex.getMessage());
                System.out.println("\nPlease re-enter the values.");
            }

        }

        employee.setAddress(address);
        employee.setDepartment(department);
        employee.setFullName(fullName);
        employee.setIsTerminated(isTerminated);
        employee.setUsername(userName);
        employee.setPassword(password);
        employee.setRole(role);

        EmployeeController ec = new EmployeeController();
        count = ec.addEmployee(employee);

        if (count == 0) {
            System.out.println("\n\t\tInsertion failed. No users were added. Please check and enter the data again.");
        } else {
            System.out.format( "\nNumber of users added= %s", count);
        }

    }

    /**
     * Terminate an employee
     * @author achyut
     * @param employee
     * @param scan
     * @return void
     */

    public void terminateEmployee(Employee employee, Scanner scan) {

        String fullName = null;
        int count = 0;
        try {
            System.out.println("\nPlease enter the employee fullname");
            fullName = scan.nextLine();
            employee.setFullName(fullName);

            EmployeeController ec = new EmployeeController();

            count = ec.terminateEmployee(employee);

        } catch (Exception ex) {
            System.out.println("Exception Occured:"+ex.getMessage());
        }
        if (count == 0) {
            System.out.println("\tNo any user to terminate");
        } else {
            System.out.format("\nNo of employee terminated = %s", count);
        }
    }
    
    /**
     * Delete an employee
     * @author achyut
     * @param employee
     * @param scan
     * @return void
     */
    public void deleteEmployee(Employee employee, Scanner scan) {

        String fullName = null;
        int count = 0;
        try {
            System.out.println("\nPlease enter the employee fullname::");
            fullName = scan.nextLine();
            employee.setFullName(fullName);

            EmployeeController ec = new EmployeeController();

            count = ec.deleteEmployee(employee);

        } catch (Exception ex) {
            System.out.println("Exception Occured:"+ex.getMessage());
        }
        if (count == 0) {
            System.out.println("\tNo any user to delete");
        } else {
            System.out.format("\nNumbe of User Deleted = %s", count);
        }
    }


    /**
     * Search an employee
     * @author achyut
     * @param employee
     * @param scan
     * @return void
     */
    public void searchEmployee(Employee employee, Scanner scan) {
        ResultSet rs = null;
        String fullName = null;
        String department = null;
        String address = null;
        try {
            System.out.println("\nPlease enter the employee fullname");
            fullName = scan.nextLine();

            System.out.println("Please enter the department");
            department = scan.nextLine();

            System.out.println("Please enter the address");
            address = scan.nextLine();

            employee.setFullName(fullName);
            employee.setAddress(address);
            employee.setDepartment(department);

            EmployeeController ec = new EmployeeController();

            rs = ec.viewEmployee(employee);
            if (rs.next()) {
                System.out.println("...........Search Results...........");
                System.out.format("%10s%25s%25s%25s%25s%25s", "ID", "USERNAME", "TERMNIATED", "FULLNAME", "DEPARTMENT", "ADDRESS");
                do {
                    System.out.println("\n");
                    System.out.format("%10s%25s%25s%25s%25s%25s", rs.getInt(1),rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    
                } while (rs.next());
            } else {
                System.out.println("\nNo Employee Records Matched.");
            }

        } catch (Exception ex) {
            System.out.println("\nError has been encountered:"+ ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("\nError has been encountered:"+ e.getMessage());
            }
        }
    }


    /**
     * Edit profile of an employee
     * @author achyut
     * @param employee
     * @param scan
     * @return Employee
     */
    public Employee editEmployeeDetails(Employee employee, Scanner scan) {        
        String userName = null;
        String password = null;
        String fullName = null;
        String department = null;
        String address = null;
        try {
            System.out.println("Enter new username:");
            userName = scan.nextLine();

            System.out.println("Enter new password:");
            password = scan.nextLine();
            
            System.out.println("Enter new fullname:");
            fullName = scan.nextLine();
            
            System.out.println("Enter new address:");
            address = scan.nextLine();
            
            System.out.println("Enter new department:");
            department = scan.nextLine();       

            if (!("".equals(userName))) {
                employee.setUsername(userName);
            }
            if (!("".equals(password))) {
                employee.setPassword(password);
            }
            if (!("".equals(fullName))) {
                employee.setFullName(fullName);
            }
            if (!("".equals(address))) {
                employee.setAddress(address);
            }
            if (!("".equals(department))) {
                employee.setDepartment(department);
            }
            

            EmployeeController empCtrl = new EmployeeController();

            return empCtrl.editEmployeeDetails(employee);

        } catch (Exception ex) {
            System.out.println("Error has been encountered:"+ ex.getMessage());
        }
        return employee;
    }

}
