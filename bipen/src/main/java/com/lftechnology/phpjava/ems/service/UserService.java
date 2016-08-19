package com.lftechnology.phpjava.ems.service;

import com.lftechnology.phpjava.ems.dao.LoginDao;
import com.lftechnology.phpjava.ems.entities.User;

/**
 * Service Layer to Validate User and show menus
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com>
 *
 */
public class UserService {

    public UserService() {

    }

    public void validateUser(String username, String password) {
        LoginDao ld = new LoginDao();

        User usr = ld.validateUser(username, password);

        if (usr.getId() == 0) {
            System.err.println("Username doesnot exist");
        } else {
            System.out.format("Welcome %s", usr.getUsername());
        }

    }

    public void showLoggedInMenu() {

    }

}
