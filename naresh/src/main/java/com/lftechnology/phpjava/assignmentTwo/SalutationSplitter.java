package com.lftechnology.phpjava.assignmentTwo;

/**
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 */
public class SalutationSplitter {
    public static String name = "";
    public static String salutaion = "";

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                name = args[0];
            } else {
                salutaion = salutaion + " " + args[i];
            }
        }
        System.out.println(name);
        System.out.println(salutaion);
    }
}
