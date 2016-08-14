package main.java.com.lftechnology.phpjava.arrays;

import java.util.HashMap;
import java.util.Map;

import main.java.com.lftechnology.phpjava.main.Scanner;

public class DayOfWeek {
    private Map<Integer, String> weekdays = new HashMap<Integer, String>();

    public DayOfWeek() {
        weekdays.put(1, "Sunday");
        weekdays.put(2, "Monday");
        weekdays.put(3, "Tuesday");
        weekdays.put(4, "Wednesday");
        weekdays.put(5, "Thursday");
        weekdays.put(6, "Friday");
        weekdays.put(7, "Saturday");
    }

    /**
     * Gets input from user(in console), and displays associated day of week name
     * 
     * @author madhav
     */
    public void findDayOfWeek() {
        System.out.println("Enter day of week number:");
        int day = Scanner.get().nextInt();
        if (weekdays.containsKey(day)) {
            System.out.println("Day is: " + weekdays.get(day));
        } else {
            System.out.println("Not a valid day.");
        }
    }
}
