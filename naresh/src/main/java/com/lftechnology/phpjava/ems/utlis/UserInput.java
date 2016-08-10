package com.lftechnology.phpjava.ems.utlis;

import java.util.Scanner;

/**
 * UserInput
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 10 2016
 */
public class UserInput {

    /**
     * Get String user input from the user
     *
     * @return
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static String getStringUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (true) {
            if (!scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                userInput = scanner.nextLine();
                if (userInput.isEmpty()) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return userInput;
    }


    /**
     * Get int user input from the user
     *
     * @return int
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static int getIntegerUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        while (true) {
            if (!scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                userInput = Integer.parseInt(scanner.nextLine());
                break;
            }
        }
        return userInput;
    }

}
