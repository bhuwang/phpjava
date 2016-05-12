package com.lftechnology.phpjava.two;
import com.lftechnology.phpjava.two.Hello2;

public class Hello3 {
	public static void main (String[] arg){
		System.out.println("Class: Hello3, print: Good Night");
		Hello2.main(new String[1]);
	}
	
	public static void test(){
		System.out.println("test function");
	}
}
