package com.lftechnology.phpjava.ems.utlis;

import com.lftechnology.phpjava.ems.constants.Constant;

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
        String userInput = scanUserInput(scanner);
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
        String userInput = scanUserInput(scanner);
        while (!isInteger(userInput)) {
            ConsoleWriter.writeUserInputRequestMessage(Constant.INVALID_OPTION_PLEASE_ENTER_AGAIN);
            ConsoleWriter.writeBlankLine(5);
            userInput = scanUserInput(scanner);
        }
        int result = Integer.parseInt(userInput);
        return result;
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param scanner
     * @return
     */
    private static String scanUserInput(Scanner scanner) {
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
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param self
     * @return
     */
    public static boolean isInteger(String self) {
        try {
            Integer.valueOf(self.trim());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
