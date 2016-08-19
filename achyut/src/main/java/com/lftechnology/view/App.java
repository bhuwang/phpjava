
package com.lftechnology.view;

import java.util.Scanner;

import com.lftechnology.controller.EmployeeController;
import com.lftechnology.entities.Employee;
import com.lftechnology.entities.User;
import com.lftechnology.entities.Role;
/**
 * Entry point of employee management system
 * @author achyut
 *
 */

public class App {

    private App() {
    }

    public static void main(String[] args) {
        /**
         * Prepare the initial user for the application if the superadmin user
         * does't exists on the system
         */
        EmployeeController empCtrl = new EmployeeController();
        empCtrl.prepareInitialUser();
        
        Scanner scanner = new Scanner(System.in);
        /** Show login view to the user **/
        LoginScreen lv=new LoginScreen();
        
        Employee employee = lv.askForLoginCredential(new User(), scanner);
        /** Unless the application is exited or have a successful login ask for input*/
        while (!Role.GUEST.equals(employee.getRole())) {
            
            employee=lv.askForLoginCredential(new User(), scanner);
        }

    }
    /**
     * Clone the employee
     * @param e1
     * @param e2
     * @return
     */
    public static Employee cloneEmployee(Employee e1, Employee e2) {

        e2.setId(e1.getId());
        e2.setUsername(e1.getUsername());
        e2.setPassword(e1.getPassword());
        e2.setFullName(e1.getFullName());
        e2.setAddress(e1.getAddress());
        e2.setDepartment(e1.getDepartment());
        e2.setIsTerminated(e1.getIsTerminated());
        e2.setRole(e1.getRole());
        return e2;
    }
    
   

}
