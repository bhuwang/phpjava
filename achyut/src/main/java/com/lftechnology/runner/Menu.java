package com.lftechnology.runner;

public class Menu {

    public Menu() {

    }

    public void showmenu() {
        System.out.println("->Please hit the options below to play with us");
        System.out.println("Options   Program");
        System.out.println("1         Salutation");
        System.out.println("2         Multiplier");
        System.out.println("3         Palindrome");
        System.out.println("0         Exit");
        System.out.println("......................");
        System.out.print("->Press the option above to continue: ");
        Executer executor = new Executer();
        executor.askForInputAndRun();
    }

}
