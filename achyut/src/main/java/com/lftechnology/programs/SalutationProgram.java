package com.lftechnology.programs;

import java.util.Scanner;

public class SalutationProgram {

    private Scanner fullNameWithSalutationInput;
    private String fullNameWithSalutation;
    private String salutation;

    public SalutationProgram() {

    }

    public void run() {
        this.initiateRun();
        this.askForInput();
        if (this.fullNameWithSalutation.length() <= 0) {
            System.out.println("->Input can't be empty! Enter again");
            this.askForInput();
        }
        this.splitInput();
        System.out.println("Salutation = " + this.salutation);
        System.out.println("FullName = " + this.fullNameWithSalutation);
        this.endRun();
    }

    public void initiateRun() {
        System.out.println("\n");
        System.out.println("->Executing Salutation");
        System.out.println("->Please Enter Your Full Name with Salutation (e.g, Mr. John Doe)\n\n");
    }

    public void endRun() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------\n\n");
    }

    public void splitInput() {
        String[] splited = this.fullNameWithSalutation.split("\\s+");
        this.salutation = splited[1];
    }

    public void askForInput() {
        fullNameWithSalutationInput = new Scanner(System.in);
        this.fullNameWithSalutation = fullNameWithSalutationInput.nextLine();
    }

}
