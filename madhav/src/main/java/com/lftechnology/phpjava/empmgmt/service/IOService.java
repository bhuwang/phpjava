package main.java.com.lftechnology.phpjava.empmgmt.service;

import java.util.Scanner;

public class IOService {
    
    public static String input() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }
    
    public static void output(String message){
        System.out.println(message);
    }
}