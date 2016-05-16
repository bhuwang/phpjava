package com.lftechnology.phpjava.pbAccess;

import java.util.Scanner;

public class PBAccess {
	public void helloWorld(){
		System.out.println("Public Access");
	}
	
	public String getNames(String fname) {
		String [] splitName = fname.split(" ");
		String newName = "";
		String ct = "";
		for(int i=0; i< splitName.length; i++) {
			if(i>0) {
				newName += ct + splitName[i];
				ct = " ";
			}
		}
		return "Salutation:"+splitName[0]+", Full Name:"+newName;						
	}
	
	
	public int getSumOfMultiple(int n,int m1, int m2) {
		int sum = 0;
		for(int i = 0; i<n; i++) {
			if((i%m1) == 0 || (i%m2)==0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public void runPB(){
		Scanner scanIn = new Scanner(System.in);
	    String fullName;
		System.out.println("Enter name with salutation: ");
		fullName = scanIn.nextLine();		
		int n;
		int m1;
		int m2;
		System.out.println("Enter total number of multiples");
		n = scanIn.nextInt();
		System.out.println("Enter multiplier m1:");
		m1 = scanIn.nextInt();
		System.out.println("Enter multiplier m2:");
		m2 = scanIn.nextInt();
	    scanIn.close();            

		
	    System.out.println(this.getNames(fullName));
		System.out.println("Sum of multiple by "+m1+" and "+m2+" below "+n+" is "+this.getSumOfMultiple(n, m1, m2));
	}
}
