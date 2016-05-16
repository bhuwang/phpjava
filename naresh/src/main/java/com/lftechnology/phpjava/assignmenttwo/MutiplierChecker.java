package com.lftechnology.phpjava.assignmenttwo;

import com.lftechnology.phpjava.menu.MenuReader;
import com.lftechnology.phpjava.menu.ProgramMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by naresh on 5/12/16.
 */
public class MutiplierChecker implements MenuReader {

    /**
     * read the user input for the action
     */
    @Override
    public void scanner() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the max value.");
        String maxValue = scan.nextLine();

        System.out.println("Please enter first number ");
        String firstNumber = scan.nextLine();
        System.out.println("Please enter second number ");
        String secondNumber = scan.nextLine();

        int result = this.multiplier(Integer.valueOf(maxValue), Integer.valueOf(firstNumber), Integer.valueOf(secondNumber));
        System.out.println("Sum of numbers below " + maxValue + " which are multiple of " + firstNumber + " and " + secondNumber + " is = " + result);

        System.out.println("\n\n\nPlease press any key to return the previous menu or enter 0 to exit.\n");

        String input = scan.nextLine();
        if (input.equals("0")) {
            ProgramMenu.run(0);
        } else {
            ProgramMenu.showMenu();
        }
    }

    /**
     * @param maxValue
     * @param firstNumber
     * @param secondNumber
     */
    public int multiplier(int maxValue, int firstNumber, int secondNumber) {
        int sum = 0;
        for (int i = 0; i < maxValue; i++) {
            if (i % firstNumber == 0 || i % secondNumber == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
