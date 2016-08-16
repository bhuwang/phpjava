package com.lftechnology.phpjava.ems.utlis;

import java.io.IOException;

/**
 * ConsoleWriter
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 10 2016
 */
public class ConsoleWriter {
    public static void writeBlankLine(int limit) {
        int counter = 0;
        while (counter < limit) {
            System.out.println();
            counter++;
        }
    }

    public static void writeUserInputRequestMessage(String message) {
        System.out.print("\t\t\t\t\t\t\t\t " + message + " \t");
    }

    public static void clearConsole()

    {
        final String operatingSystem = System.getProperty("os.name");

        try {
            if (operatingSystem.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
