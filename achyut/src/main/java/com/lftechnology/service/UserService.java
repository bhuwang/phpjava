
package com.lftechnology.service;

import com.lftechnology.appinterfaces.AppUserInterface;
import com.lftechnology.dao.DaoFactory;
import com.lftechnology.dao.UserDao;
import com.lftechnology.entities.Employee;
import com.lftechnology.entities.User;

/**
 * System service for communicating the loan database layer
 * @author achyut
 *
 */
public class UserService implements AppUserInterface {


    /**
     * Authenticates a given user
     * @author achyut
     * @param user
     */
    @Override
    public Employee authenticate(User user) {

        Employee employee = new Employee();
        UserDao ld = DaoFactory.getLoginDao();
        String userNameFormat = "[a-zA-z][a-zA-z0-9._@]+";
        if (user.getUsername().matches(userNameFormat)) {
            employee = ld.authenticate(user);
        } else {
            employee.setId(-1);
        }
        return employee;
    }
}
