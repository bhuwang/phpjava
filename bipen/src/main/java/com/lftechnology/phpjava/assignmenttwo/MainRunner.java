package com.lftechnology.phpjava.assignmenttwo;

import java.util.Scanner;

/**
 * Main Class to run the application with various available options.
 * 
 * @author Bipen Chhetri <bipenchhetri@lftechnology.com
 * 
 */
public class MainRunner {

    public static MainRunner runner;

    /**
     * Main Method which calls menu method to display menu
     * 
     * @param args
     */
    public static void main(String[] args) {
        runner = new MainRunner();
        runner.menu();
    }

    /**
     * Displays menu(option) to users.
     */
    public void menu() {
        System.out.println("Please choose what you want to do:");
        System.out.println("1 : Salutation Splitter.");
        System.out.println("2 : Multiplier.");
        System.out.println("0 : Exit");
        runner.validateInput();

    }

    /**
     * Validate Input and call method to initialize respective class.
     */
    public void validateInput() {
        Scanner userInput = new Scanner(System.in);
        if (userInput.hasNextInt()) {
            Integer choosenInput = userInput.nextInt();
            OptionFactory options = new OptionFactory();
            options.switchTask(choosenInput);
        } else {
            System.err.println("Please choose integers only!");
            this.menu();
        }

    }

}
