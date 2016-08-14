package main.java.com.lftechnology.phpjava.numbers;

import main.java.com.lftechnology.phpjava.main.Scanner;

public class Fibonacci {
    
    /**
     * Displays sum of all even fibonacci numbers within given range
     */
    public void getFibonacciSum() {
        System.out.println("Enter the limit:");
        int max = Scanner.get().nextInt();
        int f = 1;
        int sum = 0;
        int i = 0;
        while(f + i < max) {
            int j = f;
            f = i + f;
            i = j;
            if(f % 2 == 0) {
                sum += f;
            }
        } 
        System.out.println("Sum of even fibonaccis upto " + max + ": " + sum);
    }
}
