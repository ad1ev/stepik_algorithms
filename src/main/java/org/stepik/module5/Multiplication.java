package org.stepik.module5;

public class Multiplication {
    static long multiply(int a, int b) {
        System.out.println("a " + a + " b " + b);
        if (b == 0) return 0;
        long z = multiply(a, b >> 1);

        if (b % 2 == 0) return z << 1;
        else return a + (z << 1);
    }

    public static void main(String[] args) {
        System.out.println(multiply(4, 9));
        System.out.println(multiply(4, 1));
    }
}
