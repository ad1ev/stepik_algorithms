package org.stepik.module5;

import java.util.Arrays;

public class MergeSortInverse {

    private static long inverseCount;

    public static int[] sort(int[] array) {
        inverseCount = 0;
        if (array == null) return null;
        if (array.length == 0) return new int[0];
        return sort(array,0,array.length-1);
    }

    static int[] sort(int[] array, int low, int high) {
        if (low > high - 1) return new int[] { array[low] };
        int mid = low + (high - low) / 2;

        return merge(sort(array,low,mid), sort(array,mid + 1, high));
    }

    static int[] merge(int[] array1, int[] array2) {
//        System.out.println("merging " + Arrays.toString(array1) + " & " + Arrays.toString(array2));

        int cursor1 = 0;
        int cursor2 = 0;
        int[] merged = new int[array1.length + array2.length];
        int mergedCursor = 0;

        while (cursor1 < array1.length && cursor2 < array2.length) {

            if (array1[cursor1] <= array2[cursor2]) {
                merged[mergedCursor++] = array1[cursor1++];
            } else {
                merged[mergedCursor++] = array2[cursor2++];
                inverseCount += (array1.length - cursor1);
            }
        }

        while (cursor1 < array1.length)
            merged[mergedCursor++] = array1[cursor1++];

        while (cursor2 < array2.length)
            merged[mergedCursor++] = array2[cursor2++];

        return merged;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 9, 2, 9}; // 2, 2, 3, 9, 9 length = 5 high = 4

        System.out.println(Arrays.toString(sort(test)));
        System.out.println("inverse "+inverseCount);
    }
}