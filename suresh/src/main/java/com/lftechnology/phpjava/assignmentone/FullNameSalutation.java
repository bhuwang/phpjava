package com.lftechnology.phpjava.assignmentone;

import java.util.Scanner;

public class FullNameSalutation {

	public static void main(String[] args) {
		// TODO Auto-genetorated method stub
		
		System.out.println("Assignment One: Full Name Salutation.");
		
		Scanner reader = new Scanner(System.in);
		
		String firstName;
		System.out.println("Enter your first name: ");
		firstName = reader.next();
		
		String lastName;
		System.out.println("Enter your family name: ");
		lastName = reader.next();
		
		String salutation;
		System.out.println("What salutation should be used?");
		salutation = reader.next();
		
		String fullName;
		fullName = salutation + " " +firstName + " " + lastName;
		
		System.out.println("Your full name is: " + fullName);
	}

}
