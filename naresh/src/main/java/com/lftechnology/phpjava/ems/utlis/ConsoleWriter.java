package com.lftechnology.phpjava.ems.utlis;

import java.io.IOException;

/**
 * ConsoleWriter
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 10 2016
 */
public class ConsoleWriter {

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param limit
     */
    public static void writeBlankLine(int limit) {
        int counter = 0;
        while (counter < limit) {
            System.out.println();
            counter++;
        }
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param message
     */
    public static void writeUserInputRequestMessage(String message) {
        System.out.print("\t\t\t\t\t\t\t\t " + message + " \t");
    }
}
