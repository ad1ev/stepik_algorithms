package org.stepik.module1;

public class Gcd {
    public static int euclid(int a, int b) {
        return b == 0 ? a : euclid(b, a % b);
    }

    public static int euclidLoop(int a, int b) {

        while (b != 0) {
            // b = a % (a = b);
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(euclid(14159572, 63967072));
        System.out.println(euclid(63967072,14159572));

        System.out.println(euclidLoop(14159572, 63967072));
        System.out.println(euclidLoop(63967072,14159572));
        System.out.println(Math.pow(2,16));

    }
}
