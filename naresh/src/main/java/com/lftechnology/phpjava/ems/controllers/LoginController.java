package com.lftechnology.phpjava.ems.controllers;

import com.lftechnology.phpjava.ems.constants.Constant;
import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.services.UserService;
import com.lftechnology.phpjava.ems.utlis.CommonUtility;
import com.lftechnology.phpjava.ems.views.LoginView;

import java.util.HashMap;
import java.util.Map;

/**
 * LoginController
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class LoginController implements ControllerSignature<Object> {

    private static LoginView loginView = new LoginView();
    private static Map<String, Object> postData = new HashMap<>();
    private UserService userService = new UserService();
    private CommonUtility commonUtility = new CommonUtility();

    public void login() {
        loginView.setAction(Constant.LOGIN);
        loginView.render();

        User user = (User) this.postData.get(Constant.USER);
        try {
            this.userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.commonUtility.setUserService(this.userService);
    }

    public void logout() {
        loginView.logout();
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put(Constant.COMMON_UTILITY, this.commonUtility);
        return data;
    }

    @Override
    public void setData(Map<String, Object> data) {
        this.postData = data;
    }

    @Override
    public boolean isPost() {
        return false;
    }
}
