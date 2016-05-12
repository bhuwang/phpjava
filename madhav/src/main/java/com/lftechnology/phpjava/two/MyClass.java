package main.java.com.lftechnology.phpjava.two;

import java.util.Scanner;
import java.util.StringTokenizer;

import main.java.com.lftechnology.phpjava.one.PublicClass;

public class MyClass {
	public static void main(String[] args) {
		/* assignment 1 */
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println("Sum of 3/5's multiples:"+sum);
		
		/* assignment 2 */
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.print("Enter Your Name(with Salutation): ");
		String allName = reader.nextLine();
		String[] nameParts = allName.split(" ");
		System.out.println(nameParts[0]);
		System.out.println(nameParts[1]);
	}
}
