package main.java.com.lftechnology.phpjava.main;

import main.java.com.lftechnology.phpjava.arrays.DayOfWeek;
import main.java.com.lftechnology.phpjava.numbers.AddMultiples;
import main.java.com.lftechnology.phpjava.numbers.Fibonacci;
import main.java.com.lftechnology.phpjava.strings.NameSplitter;

public class Task {
    public void runTask(int taskNumber) {
        switch (taskNumber) {
        case 1:
            NameSplitter ns = new NameSplitter();
            ns.getAndExtractname();
            break;
        case 2:
            AddMultiples am = new AddMultiples();
            am.getMultiples();
            break;
        case 3:
            Fibonacci f = new Fibonacci();
            f.getFibonacciSum();
            break;
        case 4:
            DayOfWeek d = new DayOfWeek();
            d.findDayOfWeek();
            break;
        case 0:
        default:
            System.out.println("Bye!");
            System.exit(0);
        }
    }
}
