package com.lftechnology.phpjava.assignmentthree;

import java.util.Scanner;

public class Multiplier3n5 {

    public static void multiplierIterator(String[] args) {
        String status = getMultiplierRange(args);

        switch (status) {
        case "y":
            getMultiplierRange(args);
            break;
        case "Y":
            getMultiplierRange(args);
            break;
        default:
            System.out.println("End of program");
        }

    }

    public static String getMultiplierRange(String[] args) {
        Scanner reader = new Scanner(System.in);
        String continuer;

        int[] userInputNumbers = getUserInputs();

        int maxMultiple = userInputNumbers[0];
        int firstMultiplier = userInputNumbers[1];
        int secondMultiplier = userInputNumbers[2];

        int sum = 0;
        for (int i = 0; i < maxMultiple; i++) {
            sum += isMultiplier(i, firstMultiplier);
            sum += isMultiplier(i, secondMultiplier);
        }
        System.out.println(
                "For " + maxMultiple + " times, sum of the multiples of " + firstMultiplier + " and " + secondMultiplier + " is: " + sum);

        System.out.println("Do you want to continue with other set of inputs? (y/n) ");
        continuer = reader.next();

        return continuer;
    }

    static int isMultiplier(int i, int j) {
        if ((i % j) == 0) {
            return i;
        }
        return 0;
    }

    static int[] getUserInputs() {
        Scanner reader = new Scanner(System.in);

        int maxMultiple;
        System.out.println("Enter your max limit of natural numbers: ");
        maxMultiple = reader.nextInt();

        int firstMultiplier;
        System.out.println("Enter your First Multiplier: ");
        firstMultiplier = reader.nextInt();

        int secondMultiplier;
        System.out.println("Enter your Second Multiplier: ");
        secondMultiplier = reader.nextInt();

        int[] multipliers = { maxMultiple, firstMultiplier, secondMultiplier };
        return multipliers;
    }

}
