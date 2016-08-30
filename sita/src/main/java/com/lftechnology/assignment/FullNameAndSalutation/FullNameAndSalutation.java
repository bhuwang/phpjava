package com.lftechnology.assignment.FullNameAndSalutation;

import java.util.Scanner;

public class FullNameAndSalutation {

	public static void fullNameAndSalutationProcess() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter full name with saluation. Eg : Er Sita Prajapati");
		String input = scanner.nextLine();
		scanner.close();
		displayFullNameAndSalutation(input);
	}

	public static void displayFullNameAndSalutation(String fullNameWithSalutation) {
		String[] splittedString = fullNameWithSalutation.split("\\s+", 2);
		System.out.println("Salutation : " + splittedString[0]);
		System.out.println("Full Name : " + splittedString[1]);
	}
}
