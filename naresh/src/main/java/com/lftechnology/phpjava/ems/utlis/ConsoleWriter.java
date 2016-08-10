package com.lftechnology.phpjava.ems.utlis;

/**
 * ConsoleWriter
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 10 2016
 */
public class ConsoleWriter {
    public static void writeBlankLine(int limit){
        int counter = 0;
        while (counter < limit){
            System.out.println();
            counter ++;
        }
    }

    public static void writeUserInputRequestMessage(String message){
        System.out.print("\t\t\t\t\t\t\t\t " + message +" \t");
    }
}
