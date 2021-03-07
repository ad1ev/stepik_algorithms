package org.stepik.module5;

import java.util.Arrays;

public class HeapSort <T extends Comparable<T>> {

    public static <T extends Comparable<T>>void heapSort(T[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length < 2) return;

        int size = arrayToSort.length;
        buildHeap(arrayToSort);

        while (size > 1) {
            swap(arrayToSort, 0, --size);
            siftDown(arrayToSort, 0, size);
        }
    }

    private static <T extends Comparable<T>>void buildHeap(T[] array) {
        int n = (array.length - 2) / 2;
        for (int i = n; i >= 0; i--)
            siftDown(array, i, array.length);
    }

    private static <T extends Comparable<T>>void siftDown(T[] array, int i, int size) {
        int cx; // cx - child index

        if (i * 2 + 1 >= size) return;
        else if (i * 2 + 2 < size) cx = maxIndexOf(array,i * 2 + 1, i * 2 + 2);
        else cx = i * 2 + 1;

        while (cx < size && compareIndices(array, i, cx) < 0) {
            swap(array, cx, i);

            i = cx;
            cx = 2 * i + 1;

            if (cx + 1 < size) cx = maxIndexOf(array, cx, cx + 1);
        }
    }

    private static <T extends Comparable<T>>int maxIndexOf(T[] array, int i, int j) {
        return compareIndices(array, i, j) > 0 ? i : j;
    }

    private static <T extends Comparable<T>>int compareIndices(T[] array, int i, int j) {
        return array[i].compareTo(array[j]);
    }

    private static <T extends Comparable<T>>void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        Integer[] ints = {5,3,7,1,9,2,6,4,8};
        HeapSort.heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
