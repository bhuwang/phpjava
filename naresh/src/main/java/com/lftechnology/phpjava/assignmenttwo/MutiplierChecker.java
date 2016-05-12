package com.lftechnology.phpjava.assignmenttwo;

/**
 * Created by naresh on 5/12/16.
 */
public class MutiplierChecker {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.print(sum);
    }
}
