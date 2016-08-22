package com.lftechnology.employemanagement.system;

import java.sql.SQLException;
import java.util.Scanner;

import com.lftechnology.employemanagement.controller.UserController.User;

public class Menu {
	
	public static void main(String[] args) throws SQLException{
		System.out.print("Welcome to Employment Management System\n");
		Scanner input = new Scanner(System.in);
	    System.out.print("Please enter username : ");
	    String username = input.nextLine(); 
	    System.out.print("Please enter password : ");
	    String password = input.nextLine();      
	    System.out.println("You entered username and password: " + username + ":" +password);
	    User.login(username, password);
	}
}
