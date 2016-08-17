package com.lftechnology.phpjava.ems.views;

import com.lftechnology.phpjava.ems.constants.Constant;
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
        ConsoleWriter.writeUserInputRequestMessage(Constant.WELCOME_TO_EMPLOYEE_MANAGEMENT_SYSTEM);

        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.ENTER_YOUR_CREDENTAILS_TO_LOG_INTO_THE_SYSTEM);
    }


    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static void showExitMessageAndExit() {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(Constant.BYE_MESSAGE);
        ConsoleWriter.writeBlankLine(5);
        System.exit(0);
    }


    /**
     *
     * @param message
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static void showMessageAndContinue(String message) {
        ConsoleWriter.writeBlankLine(100);
        ConsoleWriter.writeUserInputRequestMessage(message);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.DO_YOU_WANT_TO_CONTINUE);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.YES);
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.NO);
        if (UserInput.getIntegerUserInput() == 1) {
            Router.showMenu();
        } else {
            showExitMessageAndExit();
        }
    }

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static void pressKeyToContinue() {
        ConsoleWriter.writeBlankLine(3);
        ConsoleWriter.writeUserInputRequestMessage(Constant.PRESS_1_TO_CONTINUE_OR_ANY_OTHER_NUMBER_TO_EXIT);
        if (UserInput.getIntegerUserInput() == 1) {
            Router.showMenu();
        } else {
            showExitMessageAndExit();
        }
    }
}
