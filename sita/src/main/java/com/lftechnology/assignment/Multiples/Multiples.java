package com.lftechnology.assignment.Multiples;

import java.util.Scanner;

public class Multiples {

	public static void multipleProcess() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the limit : ");
		int limit = scanner.nextInt();
		int sum = 0;
		for (int i = 0; i < limit; i++) {
			if ((i % 3) == 0 || (i % 5) == 0) {
				sum += i;
			}
		}
		System.out.println("Sum of Multiples of 3 and 5 : " + sum);
		scanner.close();
	}
}
