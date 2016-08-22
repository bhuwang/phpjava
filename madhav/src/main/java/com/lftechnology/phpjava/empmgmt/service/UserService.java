package main.java.com.lftechnology.phpjava.empmgmt.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.lftechnology.phpjava.empmgmt.dao.UserDao;

public class UserService {
    public static void checkDefaultUser() {
        UserDao ud = new UserDao();
        ResultSet adminUsers = ud.getAdminUsers();
        try {
            if(!adminUsers.next()) {
                String[] admin = {"Administrator", "admin", "admin", "admin"};
                ud.addUser(admin);
            }
        } catch (SQLException e) {
            IOService.output(e.getMessage());
        }
    }
}
