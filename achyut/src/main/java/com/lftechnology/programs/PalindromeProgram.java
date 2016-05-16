package com.lftechnology.programs;

import java.util.Scanner;

public class PalindromeProgram {

    private String number;
    private Scanner scanner;

    public PalindromeProgram() {

    }

    public void run() {
        this.initiateRun();
        System.out.println("->Please Enter the Number of Multiplier");
        scanner = new Scanner(System.in);
        this.number = scanner.nextLine();
        Boolean isPalindrome = this.isPalindrome();
        if (isPalindrome == true) {
            System.out.println("The number is a palindrome number");
        } else {
            System.out.println("The number is not a palindrome number");
        }
        this.endRun();
    }

    public Boolean isPalindrome() {
        String reverse = "";
        int length = this.number.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + this.number.charAt(i);

        if (this.number.equals(reverse))
            return true;
        else
            return false;

    }

    public void initiateRun() {
        System.out.println("\n");
        System.out.println("->Executing Palindrome Program");

    }

    public void endRun() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------\n\n");
    }

}
