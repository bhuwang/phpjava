package com.lftechnology.phpjava.ems.services;

import com.lftechnology.phpjava.ems.dao.UserDaoImpl;
import com.lftechnology.phpjava.ems.entities.User;

import java.sql.SQLException;

/**
 * UserService
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 09 2016
 */
public class UserService {

    private boolean isLoggedIn = false;

    UserDaoImpl userDao = new UserDaoImpl();


    public void login(User user) {
        try {
            User result = userDao.findByUsernamePassword(user);
            if (user.getUsername().equals(result.getUsername())) {
                isLoggedIn = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserLoggedIn() {
        return isLoggedIn;
    }

    public void logout() {
        this.isLoggedIn = false;
    }
}
