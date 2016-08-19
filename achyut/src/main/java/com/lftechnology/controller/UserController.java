
package com.lftechnology.controller;

import java.util.Scanner;
import com.lftechnology.service.UserService;
import com.lftechnology.service.ServiceFactory;
import com.lftechnology.entities.Employee;
import com.lftechnology.entities.User;
import com.lftechnology.entities.Role;
import com.lftechnology.view.UserMenu;
/**
 * Controller for handling the user actions
 * @author achyut
 *
 */

public class UserController {
    
    /**
     * Validate and login a user
     * @param user
     * @param scan
     */
    public void login(User user, Scanner scan) {
        Employee employee = new Employee();
        UserService ls = ServiceFactory.getLoginService();

        employee = ls.authenticate(user);

        if (employee.getId() == 0) {
            System.out.println("\nLogin Failed. No username and password matched");
        } else {
            System.out.format("Welcome %s", employee.getFullName());
            UserMenu userMenu = new UserMenu();            
            if (employee.getRole().equals(Role.ADMIN)) {
                userMenu.displayAdminMenu(employee, scan);
            } else {                
                userMenu.displayUserMenu(employee, scan);
            }
        }

    }
    
    /**
     * Prepare a user for logout making the user GUEST
     * @param employee
     * @param sc
     * @return Employee
     */
    public static Employee logOut(Employee employee, Scanner sc) {
        System.out.println("\nYou Wanna Sign Out?");
        System.out.println("tyes = 1\t\tno = 2");

        int check = Integer.parseInt(sc.nextLine());
        if (check == 1) {
            employee.setRole(Role.GUEST);
            employee.setId(0);
            employee.setUsername("");
            employee.setPassword("");
            employee.setIsTerminated(true);            
            employee.setFullName("");
            employee.setAddress("");
            employee.setDepartment("");       
        }
        return employee;
    }

}
