package com.lftechnology.phpjava.ems.controller;

import com.lftechnology.phpjava.ems.service.UserService;

public class LoginController {

    public static void login(String username, String password) {
        UserService us = new UserService();

        us.validateUser(username, password);

    }

}
