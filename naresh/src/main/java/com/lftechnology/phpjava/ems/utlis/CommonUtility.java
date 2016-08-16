package com.lftechnology.phpjava.ems.utlis;

import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.services.UserService;

/**
 * CommonUtility
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 15 2016
 */
public class CommonUtility {
    public UserService userService = new UserService();

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isLoggedIn() {
        return this.userService.isUserLoggedIn();
    }

    public boolean isAdmin() {
        return this.getUserService().getLoggedInUserRole().equals(Role.ADMIN.toString());
    }

    public boolean isUser() {
        return this.getUserService().getLoggedInUserRole().equals(Role.USER.toString());
    }
}
