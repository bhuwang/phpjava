package main.java.com.lftechnology.phpjava.numbers;

import main.java.com.lftechnology.phpjava.main.Scanner;

public class AddMultiples {
    
    /**
     * Gets three inputs - limit, number1, and number2 from user.
     * Then displays sum of all multiples of either number1 or number2 below the limit.
     */
    public void getMultiples() {
        System.out.println("Enter the limit:");
        int max = Scanner.get().nextInt();
        System.out.println("Enter the first number:");
        int num1 = Scanner.get().nextInt();
        System.out.println("Enter the second number:");
        int num2 = Scanner.get().nextInt();
        int sum = 0;
        for (int i = 0; i < max; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println("Sum of " + num1 + " and " + num2 + "'s multiples upto " + max + ": " + sum);
    }
}
