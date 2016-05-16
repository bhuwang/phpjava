package com.lftechnology.runner;

import com.lftechnology.com.programs.MultiplierProgram;
import com.lftechnology.com.programs.PalindromeProgram;
import com.lftechnology.com.programs.SalutationProgram;

public class TaskSwitcher {

    protected int chosenOption;

    public TaskSwitcher(int option) {
        this.chosenOption = option;

    }

    public void switchAndRun() {

        switch (this.chosenOption) {
        case 1:
            SalutationProgram salutationProgram = new SalutationProgram();
            salutationProgram.run();
            break;
        case 2:
            MultiplierProgram multiplierProgram = new MultiplierProgram();
            multiplierProgram.run();
            break;
        case 3:
            PalindromeProgram palindromeProgram = new PalindromeProgram();
            palindromeProgram.run();
            break;
        case 0:
            System.out.println("You are exiting the program now...");
            System.out.println("Exited");
            System.exit(0);
        default:
            System.out.println("Invalid grade");
        }
        System.out.println("Program Completed.");
        Menu menu = new Menu();
        menu.showmenu();
    }
}
