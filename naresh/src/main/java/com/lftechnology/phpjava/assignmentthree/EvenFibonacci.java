package com.lftechnology.phpjava.assignmentthree;

import com.lftechnology.phpjava.menu.MenuReader;
import com.lftechnology.phpjava.menu.ProgramMenu;

import java.util.Scanner;

/**
 * Created by naresh on 5/16/16.
 */
public class EvenFibonacci implements MenuReader {
    /**
     * read the user input for the action
     */
    @Override
    public void scanner() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the max value.");
        String maxValue = scan.nextLine();
        int max = Integer.valueOf(maxValue);
        int counter = 0;
        int sum = 0;
        int a, b, c;
        a = 1;
        b = 2;

        while (counter < max) {
            c = a + b;
            a = b;
            b = c;
            counter = b;
            if (counter > max) {
                break;
            }
            if (counter % 2 == 0) {
                sum = sum + counter;
            }
        }
        System.out.println("Sum of fibonacci numbers is :" + sum);
        System.out.println("\n\n\nPlease press any key to return the previous menu or enter 0 to exit.\n");

        String input = scan.nextLine();
        if (input.equals("0")) {
            ProgramMenu.run(0);
        } else {
            ProgramMenu.showMenu();
        }
    }
}
