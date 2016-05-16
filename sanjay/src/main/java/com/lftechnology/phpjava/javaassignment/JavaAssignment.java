package com.lftechnology.phpjava.javaassignment;

import java.util.Scanner;
import java.util.StringJoiner;

public class JavaAssignment {
    private int fibEvenNumber = 0;

    /**
     * Split Salutation and full name
     * 
     * @param fname
     *            Full name with salutation
     * @return
     */
    public String nameSplitter(String fname) {
        String[] splitName = fname.split(" ");
        String newName = "";
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = 1; i < splitName.length; i++) {
            if (splitName[i] != null) {
                newName += stringJoiner.add(splitName[i]);
            }
        }
        return "Salutation:" + splitName[0] + ", Full Name:" + newName;
    }

    /**
     * 
     * @param numberMultiplier
     * @param firstMultiplier
     * @param secondMultiplier
     * @return
     */
    public int getSumOfMultiple(int numberMultiplier, int firstMultiplier, int secondMultiplier) {
        int sum = 0;
        for (int i = 0; i < numberMultiplier; i++) {
            if ((i % firstMultiplier) == 0 || (i % secondMultiplier) == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Get Fibnaci number
     */
    public int fibanaci(int fibNumber) {
        if (fibNumber == 0 || fibNumber == 1) {
            return 1;
        }
        if (fibNumber % 2 == 0) {
            this.fibEvenNumber += fibNumber;
        }
        return this.fibanaci(fibNumber - 1) + this.fibanaci(fibNumber - 2);
    }

    public int getEvenFibNumber() {
        return this.fibEvenNumber;
    }

    public void generateMenu() {
        System.out.println("*****Menu Assignment*******");
        System.out.println("* Press 1 for name splitter");
        System.out.println("* Press 2 for name Multiplier");
        System.out.println("* Press 3 for name Fibnaci");
        System.out.println("* Press 0 for exit");
        System.out.println("***************************");
    }

    public void generateAssignmentMenu(int menuAccess) {
        Scanner scanIn = new Scanner(System.in);
        switch (menuAccess) {
        case 1:
            String fullName;
            System.out.println("Enter name with salutation: ");
            fullName = this.nameSplitter(scanIn.nextLine());
            System.out.println(fullName);
            break;
        case 2:
            int numberMultiplier, firstMultiplier, secondMultiplier;
            System.out.println("Enter total number of multiples");
            numberMultiplier = scanIn.nextInt();
            System.out.println("Enter multiplier m1:");
            firstMultiplier = scanIn.nextInt();
            System.out.println("Enter multiplier m2:");
            secondMultiplier = scanIn.nextInt();
            System.out.println("Sum of multiple by " + firstMultiplier + " and " + secondMultiplier + " below " + numberMultiplier + " is "
                    + this.getSumOfMultiple(numberMultiplier, firstMultiplier, secondMultiplier));
            break;
        case 3:
            int fibNumber;
            int totalFib;
            System.out.println("Enter Fibnaci Number less than 4 million: ");
            fibNumber = scanIn.nextInt();
            if (fibNumber <= 4000000) {
                totalFib = this.fibanaci(fibNumber);
                System.out.println("Fib Total:" + totalFib + " Sum Fib " + this.getEvenFibNumber());
            } else {
                System.out.println("Greater than 4 million.");
            }

            break;
        case 0:
            System.out.println("Thank you!! ");
            System.exit(0);
            break;
        }
    }
}
