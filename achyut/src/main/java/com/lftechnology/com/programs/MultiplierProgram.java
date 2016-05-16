package com.lftechnology.com.programs;

import java.util.Scanner;

public class MultiplierProgram {

    private int numberOfMultiple;
    private int firstMultiplier;
    private int secondMultiplier;
    private Scanner scanner;

    public MultiplierProgram() {

    }

    public void run() {
        this.initiateRun();
        System.out.println("Please Enter the Number of Multiplier");
        scanner = new Scanner(System.in);
        this.numberOfMultiple = scanner.nextInt();
        System.out.println("Please Enter First Multiplier");
        this.firstMultiplier = scanner.nextInt();
        System.out.println("Please Enter Second Multiplier");
        this.secondMultiplier = scanner.nextInt();
        int sum = calculateMultiplier();
        System.out.println("Sum of multiple by " + this.firstMultiplier + " and " + this.secondMultiplier + " below "
                + this.numberOfMultiple + "=" + sum);
        System.out.println("Executing Multiplier");
        this.endRun();
    }

    public int calculateMultiplier() {

        int sum = 0;
        for (int i = 0; i < this.numberOfMultiple; i++) {
            if ((i % this.firstMultiplier) == 0 || (i % this.secondMultiplier) == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public void initiateRun() {
        System.out.println("\n");
        System.out.println("Executing Multiplier");

    }

    public void endRun() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------\n\n");
    }

}
