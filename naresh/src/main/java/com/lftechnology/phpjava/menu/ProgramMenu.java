package com.lftechnology.phpjava.menu;

import com.lftechnology.phpjava.assignmentthree.EvenFibonacci;
import com.lftechnology.phpjava.assignmentthree.LargestPalindrome;
import com.lftechnology.phpjava.assignmenttwo.MutiplierChecker;
import com.lftechnology.phpjava.assignmenttwo.SalutationSplitter;

import java.util.Scanner;

/**
 * Created by naresh on 5/16/16.
 */
public class ProgramMenu {
    public static String[] menu = {
            "1. Split Salutation",
            "2. Check Multiple",
            "3. Find Largest Palindrome",
            "4. Even Fibonacci",
            "0. To Exit",
    };

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("Please enter the option number");
        Scanner scan = new Scanner(System.in);
        for (String option : menu) {
            System.out.println(option);
        }
        int index = scan.nextInt();
        run(index);
    }

    public static void run(int index) {
        switch (index) {
            case 1:
                SalutationSplitter salutationSplitter = new SalutationSplitter();
                salutationSplitter.scanner();
                break;
            case 2:
                MutiplierChecker mutiplierChecker = new MutiplierChecker();
                mutiplierChecker.scanner();
                break;
            case 3:
                LargestPalindrome largestPalindrome = new LargestPalindrome();
                largestPalindrome.scanner();
                break;
            case 4:
                EvenFibonacci evenFibonacci = new EvenFibonacci();
                evenFibonacci.scanner();
                break;
            case 0:
                System.out.println("Tata Horn OK please. :)");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please enter the number mentioned in the menu.");
                Scanner scan = new Scanner(System.in);
                System.out.println("Please press any key to return the previous menu or enter 0 to exit");
                String input = scan.nextLine();
                if (input.equals("0")) {
                    System.exit(0);
                } else {
                    showMenu();
                }
                break;

        }
    }
}
