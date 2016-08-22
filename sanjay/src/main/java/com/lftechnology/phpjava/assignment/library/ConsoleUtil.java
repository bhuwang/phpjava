package com.lftechnology.phpjava.assignment.library;

import java.util.Scanner;

public class ConsoleUtil {
    public static void consoleWrite(String message){
        System.out.print(message);
    }
    
    public static String gerUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (true) {
            if (!scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                userInput = scanner.nextLine();
                if (userInput.isEmpty()) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return userInput;
    }
}
