package com.lftechnology.phpjava.ems.controllers;

import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.services.UserService;
import com.lftechnology.phpjava.ems.utlis.ConsoleWriter;
import com.lftechnology.phpjava.ems.utlis.PasswordHashGenerator;
import com.lftechnology.phpjava.ems.utlis.UserInput;

/**
 * LoginController
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class LoginController {

    private static UserService userService = new UserService();

    public static void login() {
        User user = new User();
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Enter your username:");
        user.setUsername(UserInput.getStringUserInput());

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Enter your password:");
        try {
            user.setPassword(UserInput.getStringUserInput());
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.login(user);
    }

    public static void logout() {
        userService.logout();
    }
}
