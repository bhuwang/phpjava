package main.java.com.lftechnology.phpjava.main.views;

import main.java.com.lftechnology.phpjava.main.Scanner;

public class Menu {
    public static String[] menu = { 
            "1. Extract salutation from name", 
            "2. Check sum of multiples", 
            "3. Find sum of fibonaccis", 
            "4. Get day of week", 
            "0. Exit" 
            };

    public static int getMenu() {
        System.out.println("Please enter the action to perform:");
        for (String option : menu) {
            System.out.println(option);
        }
        int option = Scanner.get().nextInt();
        return option;
    }
}
