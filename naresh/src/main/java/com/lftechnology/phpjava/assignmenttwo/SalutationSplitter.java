package com.lftechnology.phpjava.assignmenttwo;

/**
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 */
public class SalutationSplitter {
    public static String name = "";
    public static String salutaion = "";

    public static void main(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (i == 0) {
                    salutaion = args[0];
                } else {
                    name = name + " " + args[i];
                }
            }
            if (name.length() > 0 || salutaion.length() > 0) {
                System.out.print("Salutaion: " + salutaion);
                System.out.println("\tYour Name: " + name);
            }
        } else {
            System.out.println("Please provide salutaion and name.");
        }
    }
}
