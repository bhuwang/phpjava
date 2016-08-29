package com.lftechnology.runner;

import java.util.Scanner;

public class Executer {

    private static Scanner userInput;
    public static int chosenOption;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showmenu();
    }

    public void askForInputAndRun() {
        /**
         * @todo Check if user input is empty in all the subsequent classes
         */
        userInput = new Scanner(System.in);
        Executer.chosenOption = userInput.nextInt();
        TaskSwitcher taskSwitcher = new TaskSwitcher(Executer.chosenOption);
        taskSwitcher.switchAndRun();
    }

}
