package com.lftechnology.phpjava.ems.views;

import com.lftechnology.phpjava.ems.controllers.LoginController;
import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.services.UserService;
import com.lftechnology.phpjava.ems.utlis.CommonUtility;
import com.lftechnology.phpjava.ems.utlis.ConsoleWriter;
import com.lftechnology.phpjava.ems.utlis.UserInput;

import java.util.HashMap;
import java.util.Map;

/**
 * LoginView
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 15 2016
 */
public class LoginView implements ViewSignature<Object> {
    private CommonUtility commonUtility = new CommonUtility();
    private User user = new User();
    private LoginController loginController = new LoginController();
    private UserService userService = new UserService();
    private String action;

    @Override
    public void render() {
        if (this.getAction().equals("login")) {
            this.login();
        } else {
            this.logout();
        }

    }

    @Override
    public String getAction() {
        return this.action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put("commonUtility", this.commonUtility);
        return data;
    }

    @Override
    public void setData(Map<String, Object> data) {
    }

    public void login() {
        Map<String, Object> postData = new HashMap<>();

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Enter your username:");
        this.user.setUsername(UserInput.getStringUserInput());

        ConsoleWriter.writeUserInputRequestMessage("Enter your password:");
        this.user.setPassword(UserInput.getStringUserInput());

        postData.put("user", this.user);
        this.loginController.setData(postData);
    }

    public void logout() {
        this.userService.logout();
    }

}
