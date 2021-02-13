package org.stepik.module1;

public class BigO {
    public static void main(String[] args) {
        System.out.println(13.0/8.0);
        double val = 10e50;
        System.out.println(log(log(val,2),2));
        System.out.println(Math.sqrt(log(val,4)));
    }

    public static double log(double val, int base) {
        return Math.log(val) / Math.log(base);
    }
}
