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

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param userService
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public boolean isLoggedIn() {
        return this.userService.isUserLoggedIn();
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public boolean isAdmin() {
        return this.getUserService().getLoggedInUserRole().equals(Role.ADMIN.toString());
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    public boolean isUser() {
        return this.getUserService().getLoggedInUserRole().equals(Role.USER.toString());
    }
}
