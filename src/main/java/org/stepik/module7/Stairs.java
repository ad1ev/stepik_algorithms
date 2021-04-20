package org.stepik.module7;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Задача:
 *
 * Даны число 1 <= n <= 100 ступенек лестницы и целые
 * числа -10000 <= a1, a2 .. an <= 10000, которыми помечены ступеньки.
 * Найдите максимальную сумму, которую можно получить, идя по лестнице
 * снизу вверх (от нулевой до n-й ступеньки),каждый раз поднимаясь на
 * одну или две ступеньки.
 *
 * Решение:
 *
 * Для каждой ступеньки выбирается максимум из суммы предыдущей и до предыдущей т.е.
 * max(current - 1, current - 2).
 * Задача схожа с задачей с нахождением чисел фибоначи.
 * */
public class Stairs {
    private static String input = "5\n" +
            "-2 -16 -13 -9 -48";

    private static int maxSum(int[] stairs, int[] D, int step) {
        if (step < 0) return 0;
        if (D[step] > Integer.MIN_VALUE) return D[step];

        D[step] = stairs[step] + Math.max(
                maxSum(stairs, D, step - 1),
                maxSum(stairs, D, step - 2)
        );

        return D[step];
    }

    private static int maxSumIteratively(int[] stairs) {
        if (stairs.length == 1) return stairs[0];

        int prevSum = stairs[0];
        int sum = stairs[1] + Math.max(prevSum, 0);

        for (int i = 2; i < stairs.length; i++) {
            sum = Math.max(prevSum , (prevSum = sum)) + stairs[i];
        }

        return sum;
    }

    private static int maxSumIterativelyUsingArray(int[] stairs) {
        if (stairs.length == 1) return stairs[0];

        int[] D = new int[stairs.length];
        D[0] = stairs[0];
        D[1] = stairs[1] + Math.max(D[0], 0);

        for (int i = 2; i < stairs.length; i++) {
            D[i] = Math.max(D[i - 1], D[i - 2]) + stairs[i];
        }

        return D[stairs.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int[] stairs = new int[sc.nextInt()];
        for (int i = 0; i < stairs.length; i++) {
            stairs[i] = sc.nextInt();
            System.out.print(stairs[i] + " ");
        }
        System.out.println("\n===");

        int[] D = new int[stairs.length];
        Arrays.fill(D, Integer.MIN_VALUE);
        System.out.println(maxSum(stairs, D, stairs.length-1));
        System.out.println(maxSumIterativelyUsingArray(stairs));
        System.out.println(maxSumIteratively(stairs));
    }
}
