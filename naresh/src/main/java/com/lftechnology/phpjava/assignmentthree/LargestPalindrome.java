package com.lftechnology.phpjava.assignmentthree;


import com.lftechnology.phpjava.menu.MenuReader;
import com.lftechnology.phpjava.menu.ProgramMenu;

import java.util.Scanner;

/**
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 */
public class LargestPalindrome implements MenuReader {

    /**
     * find the largest palindrome number
     *
     * @param startIndex
     * @param endIndex
     * @return
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public long findLargestPalindrome(int startIndex, int endIndex) {
        long palindrome = 0;
        int max = Math.max(startIndex, endIndex);
        int min = Math.min(startIndex, endIndex);
        for (int i = max; i >= min; i--) {
            for (int j = max; j >= min; j--) {
                long product = i * j;
                if (palindrome < product && isPalindrome(product)) {
                    palindrome = product;
                }
            }
        }
        return palindrome;
    }

    /**
     * check if the number is palindrome or not
     *
     * @param nr
     * @return
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public boolean isPalindrome(long nr) {
        long rev = 0;                    // the reversed number
        long x = nr;                     // store the default value (it will be changed)
        while (x > 0) {
            rev = 10 * rev + x % 10;
            x /= 10;
        }
        return nr == rev;               // returns true if the number is palindrome
    }

    /**
     * read the user input for the action
     */
    @Override
    public void scanner() {
        System.out.println("Please enter two numbers to find out the largest palindrome possible from the its product.");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter first number ");
        String firstNumber = scan.nextLine();
        System.out.println("Please enter second number ");
        String secondNumber = scan.nextLine();

        long palindrome = this.findLargestPalindrome(Integer.valueOf(firstNumber), Integer.valueOf(secondNumber));
        System.out.println("Largest possible palindrome from the product of " + firstNumber + " and " + secondNumber + " is = " + palindrome);

        System.out.println("\n\n\nPlease press any key to return the previous menu or enter 0 to exit.\n");

        String input = scan.nextLine();
        if (input.equals("0")) {
            ProgramMenu.run(0);
        } else {
            ProgramMenu.showMenu();
        }
    }
}
