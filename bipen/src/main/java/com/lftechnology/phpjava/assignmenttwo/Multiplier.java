package com.lftechnology.phpjava.assignmenttwo;

import java.util.Scanner;

/**
 * Class to generate the sum of all the multiples of two numbers below certain multiplier.
 * 
 * @author bipen
 *
 */
public class Multiplier {

    private Scanner scanner;

    /**
     * Main method that runs the program and generated the sum of all the multiples of two numbers below certain multiplier.
     * 
     * @author bipen
     */
    public void run() {
        this.scanner = new Scanner(System.in);
        System.out.println("Enter Multiplier:");
        this.validateInput();
        Integer multiplier = this.scanner.nextInt();
        System.out.println("Enter First Number:");
        this.validateInput();
        Integer firstNumber = this.scanner.nextInt();
        System.out.println("Enter Second Number:");
        this.validateInput();
        Integer secondNumber = this.scanner.nextInt();
        Integer result = calculateMultiplier(multiplier, firstNumber, secondNumber);
        System.out.println("Sum of multiple by " + firstNumber + " and " + secondNumber + " below " + multiplier + " is " + result);
    }

    /**
     * Calculate Multipliers
     * 
     * @param multiplier
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    public int calculateMultiplier(int multiplier, int firstNumber, int secondNumber) {
        int sum = 0;
        for (int i = 0; i < multiplier; i++) {
            if ((i % firstNumber) == 0 || (i % secondNumber) == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Validates user input(Displays error message if input value is not valid.
     */
    public void validateInput() {
        if (!this.scanner.hasNextInt()) {
            System.err.println("Invalid Entry. Please try again.\n");
            this.run();
        }
    }
}
