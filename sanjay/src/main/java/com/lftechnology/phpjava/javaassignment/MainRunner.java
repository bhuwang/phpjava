package com.lftechnology.phpjava.javaassignment;

import java.util.Scanner;

public class MainRunner {
    public static void main(String args[]) {
        int menuAccess = 0;
        JavaAssignment ja = new JavaAssignment();
        try (Scanner menuScanIn = new Scanner(System.in)) {
            do {
                ja.generateMenu();
                System.out.println("Select any item from the menu:");
                menuAccess = menuScanIn.nextInt();
                ja.generateAssignmentMenu(menuAccess);
            } while (menuAccess != 0);
        } catch (Exception e) {

        }
    }
}
