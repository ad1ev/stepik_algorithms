package org.stepik.module5;

import java.util.Arrays;

public class MergeSortImproved {
    private static int[] buff;
    public static void sort(int[] array) {
        if (array == null || array.length < 1) return;

        buff = new int[array.length];
        sort(0, array.length-1, array);
        buff = null;
    }

    private static void sort(int low, int high, int[] array) {
        if (high <= low) return;

        int mid = low + ((high - low) >> 1);
        sort(low, mid, array);
        sort(mid + 1, high, array);
        merge(low,mid,mid+1,high,array);
    }

    private static void merge(int l1, int r1, int l2, int r2, int[] inArray) {
        int c = 0;
        int start = l1;

        while (l1 <= r1 && l2 <= r2) {
            if (inArray[l1] < inArray[l2]) {
                buff[c++] = inArray[l1++];
            } else {
                buff[c++] = inArray[l2++];
            }
        }
        while (l1 <= r1) {
            buff[c++] = inArray[l1++];
        }
        while (l2 <= r2) {
            buff[c++] = inArray[l2++];
        }
        System.arraycopy(buff,0,inArray,start, r2 - start + 1);
    }

    public static void main(String[] args) {
        int[] ints = {5,3,7,1,9,6,4,2,8};
        MergeSortImproved.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
