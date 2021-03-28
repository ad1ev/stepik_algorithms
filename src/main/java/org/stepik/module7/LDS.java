package org.stepik.module7;

import java.io.ByteArrayInputStream;
import java.util.*;

public class LDS {
    static byte[] testInput = "5\n5 3 4 4 2".getBytes();

    public static int[] ldsN2(int[] arr) {
        int n = arr.length;
        int[] lens = new int[n];

        for (int i = 0; i < n; i++) {
            lens[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i] && lens[j] + 1 > lens[i]) {
                    lens[i] = lens[j] + 1;
                }
            }
        }

        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (maxValue < lens[i]) {
                maxValue = lens[i];
                maxIndex = i;
            }
        }

        int[] indices = new int[maxValue];
        indices[--maxValue] = maxIndex;

        for (int i = maxIndex - 1; i > 0; i--) {
            if (lens[i] == maxValue && arr[i] >= arr[maxIndex]) {
                maxIndex = i;
                indices[--maxValue] = maxIndex;
            }
        }
        return indices;
    }

    private static int[] lds(int[] arr) {
        if (arr.length == 0) return new int[0];

        int[] L = new int[arr.length];
        int[] I = new int[arr.length];
        int[] prev = new int[arr.length];// Arrays.fill(prev, -1);

        int max = 0, lastElementIdx = 0, idx;

//        L[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            idx = binarySearch(arr[i], L,-1, max + 1);
            L[idx] = arr[i];
            I[idx] = i;
            if (idx - 1 >= 0) prev[i] = I[idx - 1];

            if (max <= idx) {
                max = idx;
                lastElementIdx = i;
            }
        }

        int[] indices = new int[max + 1];
        for (int i = max; i >= 0; i--) {
            indices[i] = lastElementIdx;
            lastElementIdx = prev[lastElementIdx];
        }

        return indices;
    }

    static int binarySearch(int key, int[] sortedArray, int l, int r) {
        while (l + 1 < r) {
            int mid = l + ((r - l) >> 1);
            if (key <= sortedArray[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new ByteArrayInputStream(testInput));
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();

        int[] res = lds(arr);
        System.out.println(res.length);
        for (int r : res) {
            System.out.print((r + 1) + " ");
        }
    }
}

//        int[] test = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1};         // 1 3 4 5 9
//        int[] test = {5, 3, 4, 4, 2};
//        lds(test);