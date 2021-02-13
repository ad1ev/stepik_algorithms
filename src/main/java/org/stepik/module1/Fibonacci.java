package org.stepik.module1;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static long of(int n) {
        double sqrt5 = Math.sqrt(5);
        double f = 1 / sqrt5 *
                (Math.pow((1 + sqrt5)/2,n) - Math.pow((1 - sqrt5)/2,n));

        return Math.round(f);
    }

    public static long ofByMultFi(int n) {
        double fi = 1.6180339887498948482;
        double res = 13;
        for (int i = 7; i < n; i++) {
            res = res * fi;
        }
        System.out.println(res);
        return Math.round(res);
    }

    public static long ofByLoop(int n) {
        // i -> 0 sum - 1, prev - 0
        // i -> 1 sum - 1, prev - 1
        // i -> 2 sum - 2, prev - 1
        // i -> 3 sum - 3, prev - 2
        // i -> 4 sum - 5, prev - 3
        long sum = 0;
        long prev = 1;

        for (int i = 0; i < n; i++) {
            sum = sum + prev;
            prev = sum - prev;
        }
        return sum;
    }

    public static long ofByArray(int n) {
        long[] fib = new long[n];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n-1];
    }

    public static int lastNumOfFib(int n) {
        int sum = 0;
        int prev = 1;

        for (int i = 0; i < n; i++) {
            if (sum > 1_000_000)
                sum %= 10;
            sum = sum + prev;
            prev = sum - prev;
        }
        return sum % 10;
    }

    public static int lastFibNum(int n) {
        byte[] nums = {
                0, 1, 1, 2, 3, 5, 8, 3, 1, 4, 5, 9, 4, 3, 7, 0,
                7, 7, 4, 1, 5, 6, 1, 7, 8, 5, 3, 8, 1, 9, 0,
                9, 9, 8, 7, 5, 2, 7, 9, 6, 5, 1, 6, 7, 3, 0,
                3, 3, 6, 9, 5, 4, 9, 3, 2, 5, 7, 2, 9, 1, 0
        };

        return nums[n % 10];
    }



    public static long fibAndMod(long n, int m) {
        List<Long> period = new ArrayList<>(m * 2);

        long sum = 0, prev = 1, mod, i;

        for (i = 0; i < n;i++) {
            sum %= m;
            mod = sum;

            sum = sum + prev;
            prev = sum - prev;

            if (mod == 0 && i != 0 && sum % m == 1) break;
            period.add(mod);
        }

        if (i == n) return sum % m;
        return period.get((int) (n % period.size()));
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("F("+i+") = " + ofByLoop(i));
        }

        System.out.println("F20 = " + of(50));
        System.out.println("F20 = " + ofByLoop(50));
        System.out.println("F20 = " + ofByArray(20));
        System.out.println("F20 = " + ofByMultFi(20));

        System.out.println("Last Element of " + lastNumOfFib(841645));
        System.out.println("Last Element of " + lastFibNum(841645));

        long f = 15;
        for (int i = 2; i < 18; i++) {
            System.out.println("Fib "+f+" % "+ i + " ->\t" + fibAndMod(f, i) + "\t||\t" + ofByLoop((int)f)%i);
        }
    }
}

// import java.util.Scanner;
//
// class Main {
//
//  public static int modFibonacci(int fibonacci, int divideBy){
//        if (fibonacci <= 1 || divideBy == 0)
//            return 0;
//
//        int[] fNums = new int[fibonacci+1];
//        fNums[0] = 0;
//        fNums[1] = 1;
//        for (int i = 2; i < fNums.length; i++) {
//            fNums[i] = fNums[i-1] + fNums[i-2];
//            if (fNums[i] >= divideBy)
//                fNums[i] %= divideBy;
//        }
//        return fNums[fibonacci];
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int fib = in.nextInt();
//        int mod = in.nextInt();
//        System.out.println(modFibonacci(fib, mod));
//    }
//}