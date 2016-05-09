package com.lftechnology.phpjava;

import com.lftechnology.phpjava.one.Boy;
//import com.lftechnology.phpjava.one.Girl;

/**
 * 
 * @author Suresh Shrestha <sureshshrestha@lftechonology.com>
 *
 */
public class Accessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Accessor main method.");
		String oneObj = Boy.getBoy();
		Boy BoyObj = new Boy();
		BoyObj.getGender();
		
	}

}
