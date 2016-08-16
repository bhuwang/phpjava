package com.lftechnology.phpjava.ems;

import com.lftechnology.phpjava.ems.utlis.Router;

/**
 * EmployeeManagementSystem
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 12 2016
 */
public class EmployeeManagementSystem {
    public static void main(String[] args) {
//        V2_AsciiTable at = new V2_AsciiTable();
//        V2_AsciiTableRenderer rend = new V2_AsciiTableRenderer();
//        rend.setTheme(V2_E_TableThemes.UTF_HEAVY.get());
//        rend.setWidth(new WidthAbsoluteEven(160));
//        String[] rows = new String[6];
//        rows[0] = "one";
//        rows[1] = "two";
//        rows[2] = "three";
//        rows[3] = "four";
//        rows[4] = "five";
//        rows[5] = "six";
//        at.addRule();
//        at.addRow(rows);
//        at.addRule();
//        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
//        try {
//            List<Employee> employees = employeeDao.findAll();
//            for (Employee e: employees) {
//               at.addRow(e.toArray());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        at.addRule();
//        RenderedTable rt = rend.render(at);
//        System.out.println(rt);

        Router.showMenu();
//        CommonViewUtility.showWelcomeScreen();
    }
}
