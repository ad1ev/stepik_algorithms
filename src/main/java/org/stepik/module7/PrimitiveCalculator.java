package org.stepik.module7;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Задача:
 *
 * У вас есть примитивный калькулятор, который умеет выполнять
 * всего три операции с текущим числом x: заменить x на 2x, 3x или x+1.
 * По данному целому числу 1 ≤ n ≤ 10^5 определите минимальное число операций k,
 * необходимое, чтобы получить n из 1. Выведите k и последовательность промежуточных чисел.
 *
 */
public class PrimitiveCalculator {

    // Bottom-Up
    public static int[] minSeq(int n) {
        if (n == 1) return new int[0];
        if (n == 0) return new int[] { 1 };

        int[] D = new int[n + 1];
        Arrays.fill(D, Integer.MAX_VALUE);

        D[0] = 1;
        D[1] = 0;

        for (int i = 1; i < D.length; i++) {

            D[i] = Math.min(D[i], D[i - 1] + 1);

            if (i * 2 < D.length) {
                D[i * 2] = Math.min(D[i * 2], D[i] + 1);

                if (i * 3 < D.length) {
                    D[i * 3] = Math.min(D[i * 3], D[i] + 1);
                }
            }
        }

        return recovery(D);
    }

    private static int[] recovery(int[] D) {
        int n = D.length - 1;
        int current = D[n];

        int[] result = new int[D[n] + 1];
        result[current--] = n;

        for (int i = n; i > 0 && current >= 0; ) {
            if (i % 3 == 0 && D[i / 3] == current) {
                result[current--] = i / 3;
                i /= 3;
            } else if ((i & 1) == 0 && D[i / 2] == current) {
                result[current--] = i / 2;
                i /= 2;
            } else {
                result[current--] = i - 1;
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new ByteArrayInputStream("96234".getBytes()));
        int[] sequence = minSeq(sc.nextInt());

        System.out.println(sequence.length > 0 ? sequence.length - 1 : "0\n1");
        for (int i : sequence) System.out.printf("%d ", i);
    }
}
