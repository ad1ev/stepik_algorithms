package org.stepik.module5;

public class QuickSort {

    public static int[] sort(int[] array) {
        if (array == null || array.length == 0) return array;
        sort(array,0,array.length-1);
        return array;
    }

    public static void sort(int[] array, int low, int high) {
        if (high <= low) return;
        int mid = pivot(array,low,high);
        sort(array,low,mid - 1);
        sort(array,mid + 1,high);
    }

    private static int pivot(int[] array, int low, int high) {
//        int p = low + (high - low)/2;
        int p = (int) ((Math.random() * (high-low+1)) + low);

        swap(array,p,low);

        int pivot = array[low];
        int j = low + 1;

        for (int i = low + 1; i <= high; i++) {
            if (array[i] < pivot) swap(array,i,j++);
        }

        swap(array,low,j - 1);
        return j - 1;
    }


    public static int[] sortStackSafe(int[] array) {
        if (array == null || array.length == 0) return array;
        eliminatedSort(array,0,array.length-1);
        return array;
    }

    public static void eliminatedSort(int[] array, int low, int high) {
        while (low < high) {
            System.out.println("low " + low + " high " + high);
            int[] pivot = partition3(array,low,high);

            if (high - pivot[1] < pivot[0] - low) {
                eliminatedSort(array, pivot[1] + 1, high);
                high = pivot[0] - 1;
            } else {
                eliminatedSort(array, low, pivot[0] - 1);
                low = pivot[1] + 1;
            }
        }
    }

    private static int[] partition3(int[] array, int low, int high) {

        swap(array, low, medianIndex(array, low, low + (high - low)/2, high));

        int pivot = array[low];

        int j = low + 1;
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < pivot) swap(array,i,j++);
        }
        swap(array,low,j - 1);

        int k = j;
        for (int i = j; i <= high; i++) {
            if (array[i] == pivot) swap(array,i,k++);
        }

        return new int[] { j - 1, k - 1 };
    }

    public static int medianIndex(int[] array, int a, int b, int c) {
        if (array[a] < array[b]) {
            if (array[b] < array[c]) return b;
            else if (array[c] < array[a]) return a;
            else return c;
        } else {
            if (array[a] < array[c]) return a;
            else if (array[b] < array[c]) return c;
            else return b;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
//        int[] testArray = new int[] { 5, 1, 9, 3, 7, 4, 6, 2, 8 };
//        System.out.println(Arrays.toString(sort(testArray)));


    }
}
