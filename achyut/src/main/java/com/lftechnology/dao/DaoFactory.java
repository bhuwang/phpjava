
package com.lftechnology.dao;


public class DaoFactory {

    private DaoFactory() {

    }

    public static UserDao getLoginDao() {

        return new UserDao();
    }
    
    public static EmployeeDao getEmployeeDao() {

        return new EmployeeDao();
    }

   
    
}
