package main.java.com.lftechnology.phpjava.strings;

import main.java.com.lftechnology.phpjava.main.Scanner;

/**
 * 
 * @author madhav
 *
 */
public class NameSplitter {
    /**
     * Gets input from user(in console) assumed to be full name, and displays extracted salutation and name
     * 
     * @author madhav
     */
    public void getAndExtractname() {
        String allName = "";

        while (allName == "") {
            System.out.println("Enter Your Name(with Salutation): ");
            allName = Scanner.get().nextLine();
            allName = allName.trim();
            String[] nameParts = allName.split(" ");
            if (nameParts.length < 2) {
                continue;
            }
            String salutation = nameParts[0];
            String fullName = "";
            for (int i = 1; i < nameParts.length; i++) {
                fullName += nameParts[i] + " ";
            }
            fullName = fullName.trim();
            System.out.println("Salutation: " + salutation);
            System.out.println("Name: " + fullName);
        }
    }
}
