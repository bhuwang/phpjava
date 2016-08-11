package com.lftechnology.phpjava.assignmenttwo;

import java.util.Scanner;

/**
 * Class to initiate object according to the users input
 * 
 * @author bipen
 *
 */
public class OptionFactory {
    protected int choosenInput;

    /**
     * Method to initialize respective class according to user input
     * 
     * @param option
     */
    public void switchTask(int option) {
        switch (option) {
        case 1:
            SalutationSplitter salutationSplitter = new SalutationSplitter();
            salutationSplitter.run();
            break;
        case 2:
            Multiplier multiplier = new Multiplier();
            multiplier.run();
            break;
        case 0:
            System.out.println("Exiting the program now....DONE");
            System.exit(0);
        default:
            System.err.println("Invalid Choosen Number");
        }

        this.goToMainMenu();
    }

    /**
     * Displays Menu to users with option to exit or go back to main menu.
     */
    public void goToMainMenu() {
        System.out.println("Go to Main Menu?(y/n)");

        Scanner userInput = new Scanner(System.in);
        String choosenInput = userInput.next();
        if (choosenInput.equals("y")) {
            MainRunner mainRunner = new MainRunner();
            mainRunner.menu();
        } else {
            System.out.println("Exiting Program...Done");
            System.exit(0);
        }

    }

}
