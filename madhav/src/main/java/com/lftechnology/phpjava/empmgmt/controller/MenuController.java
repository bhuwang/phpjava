package main.java.com.lftechnology.phpjava.empmgmt.controller;

import main.java.com.lftechnology.phpjava.empmgmt.utils.Session;
import main.java.com.lftechnology.phpjava.empmgmt.utils.Task;
import main.java.com.lftechnology.phpjava.empmgmt.view.MenuView;

public class MenuController {
    public static void showMenu() {
        String role = Session.role;
        MenuView menu = new MenuView(role);
        String option = menu.getMenu();
        Task.runTask(option);
    }
}
