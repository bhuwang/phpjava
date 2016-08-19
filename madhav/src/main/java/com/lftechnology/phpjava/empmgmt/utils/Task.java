package main.java.com.lftechnology.phpjava.empmgmt.utils;

import main.java.com.lftechnology.phpjava.empmgmt.controller.EmployeeController;
import main.java.com.lftechnology.phpjava.empmgmt.service.IOService;

public class Task {
    public static void runTask(String taskNumber) {
        EmployeeController e = new EmployeeController();
        
        switch (taskNumber) {
        case "1":
            e.listEmployees();
            break;
        case "2":
            e.addEmployee();
            break;
        case "3":
            e.deleteEmployee();
            break;
        case "0":
        default:
            IOService.output("Exiting");
            System.exit(0);
        }
    }
}
