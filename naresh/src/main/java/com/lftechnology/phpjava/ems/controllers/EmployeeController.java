package com.lftechnology.phpjava.ems.controllers;

import com.lftechnology.phpjava.ems.constants.Constant;
import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.services.EmployeeService;
import com.lftechnology.phpjava.ems.views.CommonViewUtility;
import com.lftechnology.phpjava.ems.views.EmployeeView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EmployeeController
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class EmployeeController implements ControllerSignature<Object> {
    private static EmployeeService employeeService = new EmployeeService();
    private static EmployeeView employeeView = new EmployeeView();
    private static Map<String, Object> postData = new HashMap<>();
    private boolean isPost = false;

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void postLoginScreen() {
        employeeView.setAction(Constant.POST_LOGIN_ACTION);
        employeeView.setData(postData);
        employeeView.render();
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void addUser() {
        if (this.isPost) {
            Employee employee = (Employee) postData.get(Constant.EMPLOYEE);
            int result = 0;
            try {
                result = employeeService.addEmployee(employee);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String message;
            if (result > 0) {
                message = Constant.EMPLOYEE_ADDED_SUCCESSFULLY;
            } else {
                message = Constant.UNABLE_TO_ADD_EMPLOYEE;
            }
            postData.clear();
            this.isPost = false;
            CommonViewUtility.showMessageAndContinue(message);
        } else {
            employeeView.setAction(Constant.ADD_USER_ACTION);
            employeeView.render();
        }

    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void searchUser() {
        if (this.isPost) {
            Employee employee = (Employee) postData.get(Constant.EMPLOYEE);
            List<Employee> result = new ArrayList<>();
            try {
                result = employeeService.searchEmployee(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            employeeView.renderEmployeeList(employeeService.getColumns(), result);
            this.isPost = false;
            postData.clear();
            CommonViewUtility.pressKeyToContinue();
        } else {
            employeeView.setAction(Constant.SEARCH_USER_ACTION);
            employeeView.render();
        }
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void terminateUser() {
        if (this.isPost()) {
            Employee employee = (Employee) postData.get(Constant.EMPLOYEE);
            int result = 0;
            try {
                result = employeeService.terminateUser(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String message = result + " users were terminated";
            postData.clear();
            this.isPost = false;
            CommonViewUtility.showMessageAndContinue(message);
        } else {
            employeeView.setAction(Constant.TERMINATE_USER_ACTION);
            employeeView.render();
        }

    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void deleteUser() {
        if (this.isPost()) {
            Employee employee = (Employee) postData.get(Constant.EMPLOYEE);
            int result = 0;
            try {
                result = employeeService.deleteUser(employee);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String message = result + " users were deleted";
            postData.clear();
            this.isPost = false;
            CommonViewUtility.showMessageAndContinue(message);
        } else {
            employeeView.setAction(Constant.DELETE_USER_ACTION);
            employeeView.render();
        }
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void updateProfile() {
        if (this.isPost) {
            Employee employee = (Employee) postData.get(Constant.EMPLOYEE);
            int result = 0;
            try {
                result = employeeService.updateEmployee(employee);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.isPost = false;
            postData.clear();
            String message;
            if (result > 0) {
                message = Constant.DATA_UPDATED_SUCCESSFULLY;
            } else {
                message = Constant.UNABLE_TO_UPDATE_PROFILE;
            }
            CommonViewUtility.showMessageAndContinue(message);
        } else {
            employeeView.setAction(Constant.UPDATE_PROFILE_ACTION);
            employeeView.render();
        }
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    @Override
    public Map<String, Object> getData() {
        return null;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param data
     */
    @Override
    public void setData(Map<String, Object> data) {
        postData = data;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    @Override
    public boolean isPost() {
        return this.isPost;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public void makeCurrentRequestPost() {
        this.isPost = true;
    }
}
