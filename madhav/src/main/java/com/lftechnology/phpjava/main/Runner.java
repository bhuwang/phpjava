package main.java.com.lftechnology.phpjava.main;

import main.java.com.lftechnology.phpjava.main.views.Menu;

public class Runner {

    public static void main(String[] args) {
        int menu = Menu.getMenu();
        Task t = new Task();
        t.runTask(menu);
    }
}
