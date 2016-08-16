package com.lftechnology.phpjava.ems.views;

import com.lftechnology.phpjava.ems.utlis.ConsoleWriter;
import com.lftechnology.phpjava.ems.utlis.Router;
import com.lftechnology.phpjava.ems.utlis.UserInput;

/**
 * CommonViewUtility
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 15 2016
 */
public class CommonViewUtility {

    /**
     * Show Welcome Screen
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static void showWelcomeScreen() {
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Welcome To Employee Management System !!!");

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Enter your credentails to log into the system");
    }

    public static void showExitMessageAndExit(){
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage("Bye, Felicia");
        ConsoleWriter.writeBlankLine(5);
        System.exit(0);
    }

    public static void showMessageAndContinue(String message) {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(message);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Do you want to continue?");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("1. Yes");
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("2. No");
        if (UserInput.getIntegerUserInput() == 1) {
            Router.showMenu();
        }else{
            showExitMessageAndExit();
        }
    }

    public static void pressKeyToContinue(){
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage("Press 1 to continue or any other number to exit");
        if (UserInput.getIntegerUserInput() == 1) {
            Router.showMenu();
        }else{
            showExitMessageAndExit();
        }
    }
}
