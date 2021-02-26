package org.stepik.module5;

public class MergeSort {
    public static int[] sort(int[] array) {
        if (array == null) return null;
        if (array.length == 0) return new int[0];
        return sort(array,0,array.length-1);
    }

    static int[] sort(int[] array, int low, int high) {
        if (low == high) return new int[] { array[low] };
        else if (low + 1 == high) {
            if (array[low] < array[high]) return new int[] { array[low], array[high] };
            else return new int[] { array[high], array[low] };
        } else {
            int mid = low + (high - low) / 2;
            return merge(sort(array, low, mid), sort(array, mid + 1, high));
        }
    }

    static int[] merge(int[] array1, int[] array2) {
        int cursor1 = 0;
        int cursor2 = 0;
        int[] merged = new int[array1.length + array2.length];
        int mergedCursor = 0;

        while (cursor1 < array1.length && cursor2 < array2.length) {

            if (array1[cursor1] <= array2[cursor2])
                merged[mergedCursor++] = array1[cursor1++];
            else
                merged[mergedCursor++] = array2[cursor2++];
        }

        while (cursor1 < array1.length)
            merged[mergedCursor++] = array1[cursor1++];

        while (cursor2 < array2.length)
            merged[mergedCursor++] = array2[cursor2++];

        return merged;
    }
}
