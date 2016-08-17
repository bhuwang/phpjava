package com.lftechnology.phpjava.ems.views;

import com.lftechnology.phpjava.ems.constants.Constant;
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

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public void render() {
        if (this.getAction().equals(Constant.LOGIN)) {
            this.login();
        } else {
            this.logout();
        }

    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    @Override
    public String getAction() {
        return this.action;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param action
     */
    @Override
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put(Constant.COMMON_UTILITY, this.commonUtility);
        return data;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param data
     */
    @Override
    public void setData(Map<String, Object> data) {
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void login() {
        Map<String, Object> postData = new HashMap<>();

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_YOUR_USERNAME_TO_LOGIN);
        this.user.setUsername(UserInput.getStringUserInput());

        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_YOUR_PASSWORD_TO_LOGIN);
        this.user.setPassword(UserInput.getStringUserInput());

        postData.put(Constant.USER, this.user);
        this.loginController.setData(postData);
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void logout() {
        this.userService.logout();
    }

}
