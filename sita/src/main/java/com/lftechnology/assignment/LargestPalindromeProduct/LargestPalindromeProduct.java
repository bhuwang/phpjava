package com.lftechnology.assignment.LargestPalindromeProduct;

public class LargestPalindromeProduct {

	public static void largestPalindromeProductProcess()
	{
		int max = 100001;

		for ( int i = 999 ; i >= 100 ; i--) {
			for (int j = 999 ; j >= 100 ; j-- ) {
				int p = i * j;
				if ( max < p && isPalindrome(p) ) {
					max = p;
				}
			}
		}
		System.out.println(max);
	}

	public static boolean isPalindrome(int nr) {
		//the reversed number
		int reversedNumber = 0; 
		//// store the default value (it will be changed)
		int x = nr;                     
		while (x > 0) {
			reversedNumber = 10 * reversedNumber + x % 10;
			x /= 10;
		}

		//returns true if the number is palindrome
		return nr == reversedNumber;               
	}
}
