package main.java.com.lftechnology.phpjava.empmgmt.view;
import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class LoginView {
    public String[] login() {
        String[] loginData = new String[2];
        IOService.output("Enter username:");
        String username = IOService.input();
        IOService.output("Enter password:");
        String password = IOService.input();
        loginData[0] = username;
        loginData[1] = password;
        
        return loginData;
    }
}