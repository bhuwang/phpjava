package com.lftechnology.phpjava.assignmenttwo;

import java.util.Scanner;

/**
 * Split salutation given full name
 * 
 * @author bipen
 *
 */
public class SalutationSplitter {
    protected String salutation;
    protected String inputName;
    protected String fullName;

    /**
     * Main Method to split salutation from full name and displays result
     */
    public void run() {
        System.out.println("Please enter Full Name with salutation(Mr Bipen Chhetri):");
        Scanner name = new Scanner(System.in);
        this.inputName = name.nextLine();
        this.validateInput();
        System.out.println("Your Salutation is: " + this.salutation);
        System.out.println("Your Full Name is: " + this.fullName);
    }

    /**
     * validate inputs from users.
     */
    public void validateInput() {
        if (!this.inputName.isEmpty()) {
            this.splitName();
        } else {
            System.err.println("Input cannot be empty. Please try again.");
            this.run();
        }
    }

    /**
     * Splits salutation from full name.
     */
    public void splitName() {
        String[] splited = this.inputName.split("\\s+");
        this.salutation = splited[0];
        this.fullName = splited[1] + " " + splited[2];
    }

}
