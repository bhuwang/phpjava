package com.lftechnology.phpjava.ems.controller;

import com.lftechnology.phpjava.ems.service.UserService;
import com.lftechnology.phpjava.ems.utils.ConsoleWriter;

public class LoginController {
    protected static UserService us = new UserService();

    public static void createDefaultAdminUser() {
        try {
            us.checkDefaultAdminUser();
        } catch (Exception e) {
            ConsoleWriter.setErrorMessageToConsole("Error while creating default User : " + e.getMessage());
        }
    }

    public static void login(String username, String password) {
        try {
            us.validateUser(username, password);
        } catch (Exception e) {
            ConsoleWriter.setErrorMessageToConsole("Error on  login action: " + e.getMessage());
        }

    }

}
