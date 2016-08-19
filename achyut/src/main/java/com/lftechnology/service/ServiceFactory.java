
package com.lftechnology.service;

/**
 * A factory class to return specific services
 * @author achyut
 *
 */
public class ServiceFactory {
    private ServiceFactory() {

    }

    public static EmployeeService getEmployeeService() {

        return new EmployeeService();
    }


    public static UserService getLoginService() {

        return new UserService();
    }
}
