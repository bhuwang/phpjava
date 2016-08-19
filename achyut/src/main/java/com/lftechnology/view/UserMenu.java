
package com.lftechnology.view;

import java.util.Scanner;
import com.lftechnology.controller.UserController;
import com.lftechnology.entities.Employee;
import com.lftechnology.entities.Role;


public class UserMenu {
    
    /**
     * Show Admin Menu
     * @author achyut
     * @param employee
     * @param scan
     * @return void
     */
    public void displayAdminMenu(Employee employee, Scanner scan) {
        Employee e = new Employee();
        e = App.cloneEmployee(employee, e);
        Employee e2 = new Employee();
        e2 = App.cloneEmployee(e, e2);
        EmployeeView ev = new EmployeeView();
        do {
            try {
                System.out.println("\n**************************************************");
                System.out.println("Welcome To Admnistration");
                System.out.println("1.Add New User/Employee");
                System.out.println("2.Terminate user");
                System.out.println("3.Delete user");
                System.out.println("4.Search user");
                System.out.println("5.Edit My Profile");
                System.out.println("6.Sign Out");
                System.out.println("Please Select An Option From the Menu and hit enter");
                int choice = Math.abs(Integer.parseInt(scan.nextLine()));
                switch (choice) {
                case 1:
                    ev.addEmployee(employee, scan);
                    break;
                case 2:
                    ev.terminateEmployee(employee, scan);
                    break;
                case 3:
                    ev.deleteEmployee(employee, scan);
                    break;
                case 4:
                    ev.searchEmployee(employee, scan);
                    break;
                case 5:
                    ev.editEmployeeDetails(e, scan);
                    break;
                case 6:
                    e = UserController.logOut(employee, scan);
                    break;

                default:
                    System.out.println("This is out of menu");
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Encountered and error:"+ex.getMessage());
            }

        } while (!Role.GUEST.equals(e.getRole()));
        System.out.println("You have Successfully Signed Out");
        System.out.println("******************************");
    }
    
    /**
     * Show User Menu
     * @param employee
     * @param scan
     * @return void
     */
    public void displayUserMenu(Employee employee, Scanner scan) {
        EmployeeView ev = new EmployeeView();
        Employee emp2 = new Employee();
        emp2 = App.cloneEmployee(employee, emp2);

        Employee e2 = new Employee();
        e2 = App.cloneEmployee(emp2, e2);

        do {
            try {
                System.out.println("\n***************************Welcome to the user panel**********************\n");
                System.out.println("1.Search/View users");
                System.out.println("2.Edit personal information");
                System.out.println("3.Exit");
                System.out.println("Please Enter your choices");
                int choice = Math.abs(Integer.parseInt(scan.nextLine()));
                switch (choice) {
                case 1:
                    ev.searchEmployee(emp2, scan);
                    break;
                case 2:
                    e2 = ev.editEmployeeDetails(emp2, scan);
                    break;
                case 3:
                    emp2 = UserController.logOut(employee, scan);
                    break;
                default:
                    System.out.println("\n\t\tIncorrect Choice. Please select from the given list");
                    break;
                }

            } catch (Exception ex) {
                System.out.println("Error has been encountered:"+ex.getMessage());
            }
        } while (!Role.GUEST.equals(emp2.getRole()));
        System.out.println("Successfully signed out of the application");
    }
}
