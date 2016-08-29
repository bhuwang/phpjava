package com.lftechnology.phpjava.assignmentPrintDayInWord;

import java.util.Scanner;

public class PrintDayInWord {
public static void main(String[] args) {
		
		System.out.println("PrintDayInWord");
		
		PrintDayInWord printDayInWord = new PrintDayInWord();
		
		Scanner scanner = new Scanner(System.in);
		
		int number;
		
		System.out.print("Enter day in a number: ");
		
		if (!scanner.hasNextInt()) {
			System.out.println("Invalid input!");
		} else {
			number = scanner.nextInt();
			printDayInWord.displayDay(number);
		}

	}

	/**
	 * Prints “Sunday”, “Monday”, ... “Saturday” if the int variable "day" is 0,
	 * 1, ..., 6, respectively. Otherwise, it shall print “Not a valid day”
	 * 
	 * @author sitaprajapati
	 * @param int number
	 */
	public void displayDay(int number) {
		String day = null;
		switch (number) {
		case 0:
			day = "Sunday";
			break;
		case 1:
			day = "Monday";
			break;
		case 2:
			day = "Tuesday";
			break;
		case 3:
			day = "Wednesday";
			break;
		case 4:
			day = "Thursday";
			break;
		case 5:
			day = "Friday";
			break;
		case 6:
			day = "Saturday";
			break;
		default:
			day = "Not a valid day";
			break;

		}
		System.out.println("Day : " + day);
	}
}
