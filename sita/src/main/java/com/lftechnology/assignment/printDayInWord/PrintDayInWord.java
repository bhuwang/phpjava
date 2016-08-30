package com.lftechnology.assignment.printDayInWord;

import java.util.Scanner;

import com.lftechnology.assignment.Menu;

public class PrintDayInWord {
	
	public static void printDayInWordProcess()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter day in number.");
		int dayInNumber = scanner.nextInt();
		displayDayInWord(dayInNumber);
		scanner.close();
	}
	
	public static void displayDayInWord(int dayInNumber)
	{
		String day = null;
		switch(dayInNumber){
		case 1: 
			day = "Sunday";
			break;
		case 2: 
			day = "Monday";
			break;
		case 3: 
			day = "Tuseday";
			break;
		case 4: 
			day = "Wednesday";
			break;
		case 5: 
			day = "Thursday";
			break;
		case 6: 
			day = "Friday";
			break;
		case 7: 
			day = "Saturday";
			break;
		default: 
			System.out.println("Invalid day.");
			Menu.menuList();
			break;
		}
		
		System.out.println("Day : " + day);
	}
}
