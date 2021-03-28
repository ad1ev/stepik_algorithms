package org.stepik.module7;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class LIS {
    static byte[] input = "4\n3 6 7 12".getBytes();

    static int lisBottomUp(int[] array) {
        int[] lengths = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && lengths[j] + 1 > lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                }
            }
        }

        int maxIndex = 0;
        int maxValue = lengths[0];

        for (int i = 0; i < lengths.length; i++) {
            if (maxValue < lengths[i]) {
                maxIndex = i;
                maxValue = lengths[i];
            }
        }

        int[] indices = new int[maxValue];
        int k = maxValue - 1;
        indices[k] = maxIndex;

        for (int i = maxIndex - 1; i >= 0; i--) {
            if (lengths[i] == k && array[i] < array[indices[k]]) {
                indices[--k] = i;
            }
        }

        for (int index : indices) {
            System.out.print(array[index] + " ");
        }
        System.out.println();

        return lengths[maxIndex];
    }

    // Solution:
    public static void main(String[] args) {

//        int[] test = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1};
//        System.out.println("res = " + lisBottomUp(test));

        Scanner sc = new Scanner(new ByteArrayInputStream(input));

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();

        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && lengths[j] + 1 > lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                }
            }
        }

        int max = 0;
        for (int l : lengths) {
            if (max < l) max = l;
        }

        System.out.println(max);
    }
}
