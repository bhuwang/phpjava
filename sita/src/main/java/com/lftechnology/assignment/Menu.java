package com.lftechnology.assignment;

import java.util.Scanner;

import com.lftechnology.assignment.EvenFibonacciNumbers.EvenFibonacciNumbers;
import com.lftechnology.assignment.FullNameAndSalutation.FullNameAndSalutation;
import com.lftechnology.assignment.LargestPalindromeProduct.LargestPalindromeProduct;
import com.lftechnology.assignment.Multiples.Multiples;
import com.lftechnology.assignment.guessingNumber.GuessingNumber;
import com.lftechnology.assignment.printDayInWord.PrintDayInWord;
import com.lftechnology.assignment.smallestMultiple.SmallestMultiple;

public class Menu {

	public static void main(String[] args) {
		menuList();
	}

	public static void menuList() {
		Scanner input = new Scanner(System.in);
		list();
		int pressedOption = input.nextInt();
		filter(pressedOption);
		input.close();
	}

	public static void filter(int pressedOption) {
		switch (pressedOption) {
		case 1:
			GuessingNumber.guessingRandomNumber();
			break;
		case 2:
			PrintDayInWord.printDayInWordProcess();
			break;
		case 3:
			SmallestMultiple.smallestMultipleProcess();
			break;
		case 4:
			LargestPalindromeProduct.largestPalindromeProductProcess();
			break;
		case 5:
			EvenFibonacciNumbers.evenFibonacciNumbersProcess();
			break;
		case 6:
			Multiples.multipleProcess();
			break;
		case 7:
			FullNameAndSalutation.fullNameAndSalutationProcess();
			break;
		case 8:
			System.exit(0);
			break;
		}

		menuList();
	}

	public static void list() {
		System.out.println("\nPress 1 For Guessing number.");
		System.out.println("Press 2 For Print Day in word.");
		System.out.println("Press 3 For Smallest multiple.");
		System.out.println("Press 4 For Largest palindrome product.");
		System.out.println("Press 5 For Even Fibonacci numbers.");
		System.out.println("Press 6 For Multiples of 3 and 5.");
		System.out.println(
				"Press 7 For Create a Hello World Program which takes full name with salutation. Extract salutation and fullname from the argument and display..");
		System.out.println("Press 8 For Exit.");
	}
}
