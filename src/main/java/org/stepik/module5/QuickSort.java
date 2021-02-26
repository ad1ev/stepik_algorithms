package org.stepik.module5;

public class QuickSort {

    public static int[] sort(int[] array) {
        if (array == null || array.length == 0) return array;
        sort(array,0,array.length-1);
        return array;
    }

    public static void sort(int[] array, int low, int high) {
//        System.out.println(Arrays.toString(array) + "\tlow " + low + " high " + high);
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
        sortStackSafe(array,0,array.length-1);
        return array;
    }

    public static void sortStackSafe(int[] array, int low, int high) {
        while (low < high) {
            int mid = medianPivot3(array, low, high);
            if (high - mid < mid - low) {
                sort(array,mid + 1, high);
                high = mid - 1;
            } else {
                sort(array, low, mid - 1);
                low = mid + 1;
            }
        }
    }

    private static int medianPivot3(int[] array, int low, int high) {
        int pivIndex = medianIndex(array, low, low + (high - low)/2, high);
        int pivot = array[pivIndex];

        swap(array,pivIndex,low);

        int j = low + 1;
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < pivot) swap(array,i,j++);
        }
        swap(array,low,j - 1);

        int k = j;
        for (int i = j; i < high; i++) {
            if (array[i] == pivot) swap(array,i,k++);
        }
        return j - 1;
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
