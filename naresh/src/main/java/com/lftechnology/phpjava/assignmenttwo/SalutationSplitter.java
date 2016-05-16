package com.lftechnology.phpjava.assignmenttwo;

import com.lftechnology.phpjava.menu.MenuReader;
import com.lftechnology.phpjava.menu.ProgramMenu;

import java.util.Scanner;

/**
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 */
public class SalutationSplitter implements MenuReader {
    public void salutationSplitter(String input) {
        String name = "";
        String[] nameAndSalutation = input.split(" ");
        String salutaion = nameAndSalutation[0];
        String space = "";
        for (int i = 0; i < nameAndSalutation.length; i++) {
            if (i > 0) {
                name += space + nameAndSalutation[i];
                space = " ";
            }
        }
        System.out.println("\n\nSalutation : " + salutaion);
        System.out.println("Name : " + name);
    }


    /**
     * read the user input for the action
     */
    @Override
    public void scanner() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name and salutation.");
        String nameAndSalutation = scan.nextLine();
        salutationSplitter(nameAndSalutation);
        System.out.println("\n\n\nPlease press any key to return the previous menu or enter 0 to exit. \n");
        String input = scan.nextLine();
        if (input.equals("0")) {
            ProgramMenu.run(0);
        } else {
            ProgramMenu.showMenu();
        }
    }
}
