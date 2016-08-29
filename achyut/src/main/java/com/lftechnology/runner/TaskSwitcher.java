package com.lftechnology.runner;

import com.lftechnology.programs.MultiplierProgram;
import com.lftechnology.programs.PalindromeProgram;
import com.lftechnology.programs.SalutationProgram;

public class TaskSwitcher {

    protected int chosenOption;

    public TaskSwitcher(int option) {
        this.chosenOption = option;
    }

    public void switchAndRun() {
        Menu menu = new Menu();
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
            System.out.println("->You are exiting the program now...");
            System.out.println("->Exited");
            System.exit(0);
        default:
            System.out.println("->Invalid Input");
            System.out.println("\n");
            menu.showmenu();
        }        
        menu.showmenu();
    }
}
