package com.lftechnology.phpjava.assignmentone;

public class Multiplier3n5 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += isMultiplier(i, 3);
			sum += isMultiplier(i, 5);
		}
		System.out.println("Sum of the multiples of 3 and 5 is: " + sum);
	}
	
	static int isMultiplier(int i, int j) {
		if ((i % j) == 0) {
			return i;
		}
		return 0;
	}

}
