package org.stepik.module5;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class BinarySearch {
    static<T extends Comparable<T>> int indexOf(T key, T[] array) {
        if (array == null || array.length == 0) return -1;
        return recursively(key, array, 0, array.length - 1);
    }

    static<T extends Comparable<T>> int recursively(T key, T[] array, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        int compare = key.compareTo(array[mid]);

        if (compare < 0) return recursively(key, array, low, mid - 1);
        else if (compare > 0) return recursively(key, array, mid + 1, high);
        else return mid + 1;
    }

    static <T extends Comparable<T>>int firstOccurrence(T key, T[] sortedArray) {
        int l = 0;
        int r = sortedArray.length - 1;

        while (l + 1 < r) {
            int mid = l + ((r - l) >> 1);
            if (key.compareTo(sortedArray[mid]) <= 0) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (sortedArray[r].compareTo(key) == 0)
            return r;
        return -1;
    }

    public static void main(String[] args) {
        String input1 = "5 1 5 8 12 13\n" + "5 8 1 23 1 11";
        Scanner in = new Scanner(new ByteArrayInputStream(input1.getBytes()));
        Integer[] array = new Integer[in.nextInt()];

        for (int i = 0; i < array.length; i++)
            array[i] = in.nextInt();

        int k = in.nextInt();
        for (int i = 0; i < k; i++)
            System.out.print(indexOf(in.nextInt(), array) + " ");

        System.out.println();
        Integer[] arr = {1,2,3,3,3,3,3,3,6};
        System.out.println(firstOccurrence(3,arr));
    }
}
