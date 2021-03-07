package org.stepik.module5;

import java.util.Scanner;

public class CountSort {
    public static int[] sort(int[] ints, int M) {
        int[] counter = new int[M + 1];
        for (int i : ints) counter[i]++;

        for (int i = 2; i < counter.length; i++)
            counter[i] += counter[i - 1];

        int[] sorted = new int[ints.length];

        for (int i = ints.length - 1; i >= 0; i--) {
            int val = ints[i];
            sorted[counter[val] - 1] = val;
            counter[val]--;
        }
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] counter = new int[11];
        int[] ints = new int[sc.nextInt()];
        int[] sorted = new int[ints.length];

        for (int i = 0; i < ints.length; i++)
            counter[(ints[i] = sc.nextInt())]++;

        for (int i = 2; i < counter.length; i++)
            counter[i] += counter[i - 1];

        for (int i : ints) {
            sorted[counter[i] - 1] = i;
            counter[i]--;
        }

        for (int i : sorted) System.out.print(i + " ");
    }
}
