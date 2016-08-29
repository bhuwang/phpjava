package com.lftechnology.assignment.EvenFibonacciNumbers;

import java.util.Scanner;

public class EvenFibonacciNumbers {

	public static void evenFibonacciNumbersProcess() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the limit:");
		int max = scanner.nextInt();
		long odd1, odd2 = 1, even = 2;
		long sums = 0;
		while (even <= max) {
	        sums += even;
	        odd1 = even + odd2;
	        odd2 = odd1 + even;
	        even = odd2 + odd1;
	    }
		System.out.println("Sum of even fibonaccis upto " + max + ": " + sums);
		scanner.close();
	}
}
