package com.lftechnology.assignment.guessingNumber;

import java.util.Random;
import java.util.Scanner;

import com.lftechnology.assignment.Menu;

public class GuessingNumber {

	public static void guessingRandomNumber() {
		Random random = new Random();
		int numberToGuess = random.nextInt(20);
		GuessingNumber.getNumber(numberToGuess);
		Menu.menuList();
	}

	public static void getNumber(int numberToGuess) {
		Scanner scanner = new Scanner(System.in);
		Boolean guessing = false;

		do {
			System.out.println("Guess a number between 0-20.");
			int guessedNumber = scanner.nextInt();
			if (numberToGuess == guessedNumber) {
				guessing = true;
			} else if (numberToGuess < guessedNumber) {
				System.out.println("Number is greater than guessing number.");
			} else if (numberToGuess > guessedNumber) {
				System.out.println("Number is lesser than guessing number.");
			}
		} while (guessing == false);

		scanner.close();
		System.out.println("You won.");
	}
}
