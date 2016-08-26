package com.lftechnology.phpjava.ems.utils;

import java.util.Scanner;

/**
 * Class to print messages in console
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com>
 *
 */
public class ConsoleWriter {
    public static void setMessageToConsole(String msg) {
        System.out.println(msg);
    }

    public static void setPrintBlankLines(int i) {
        for (int counter = 1; counter <= i; counter++) {
            System.out.println();
        }
    }

    public static void setErrorMessageToConsole(String msg) {
        System.err.println(msg);
    }

    public static Integer getUserInput() {
        Integer choosenInput = 0;
        Scanner userInput = new Scanner(System.in);

        if (userInput.hasNextInt()) {
            choosenInput = userInput.nextInt();
        } else {
            ConsoleWriter.setErrorMessageToConsole("Only Integers are allowed. Please try again!");
            ConsoleWriter.setPrintBlankLines(2);
        }

        return choosenInput;

    }

}
