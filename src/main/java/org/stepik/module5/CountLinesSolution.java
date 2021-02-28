package org.stepik.module5;

import java.io.ByteArrayInputStream;
import java.util.Comparator;
import java.util.Scanner;

public class CountLinesSolution {

    private static class QuickSort{

        public static <T>void eliminatedSort(T[] array, int low, int high, Comparator<T> c) {
            while (low < high) {
                int[] piv = pivot3(array, low, high, c);

                if (high - piv[1] < piv[0] - low) {
                    eliminatedSort(array, piv[1] + 1, high, c);
                    high = piv[0] - 1;
                } else {
                    eliminatedSort(array,low,piv[0]-1,c);
                    low = piv[1] + 1;
                }
            }
        }

        private static <T>int[] pivot3(T[] array, int low, int high, Comparator<T> c) {
            swap(array,low, (int) (Math.random() * (high - low + 1)) + low);

            T pivot = array[low];

            int j = low + 1;
            for (int i = low + 1; i <= high; i++) {
                if (c.compare(array[i], pivot) < 0)
                    swap(array, i, j++);
            }
            swap(array,low,j - 1);

            int k = j;
            for (int i = j; i <= high; i++) {
                if (c.compare(array[i], pivot) == 0)
                    swap(array, i, k++);
            }

            return new int[] { j - 1, k - 1 };
        }

        private static <T>void swap(T[] inArray, int a, int b) {
            T temp = inArray[a];
            inArray[a] = inArray[b];
            inArray[b] = temp;
        }
    }

    private static class Segment {
        int a, b;

        private static final Comparator<Segment> START_COMPARATOR = Comparator.comparingInt(o -> o.a);
        private static final Comparator<Segment> END_COMPARATOR = Comparator.comparingInt(o -> o.b);
        private static Comparator<Segment> comparator;

        public Segment(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public static int indexOfFirstLess(Segment key, Segment[] array) {
            comparator = Segment.END_COMPARATOR;
            return searchRecursively(key,array,0,array.length-1, true);
        }

        public static int indexOfFirstGreater(Segment key, Segment[] array) {
            comparator = Segment.START_COMPARATOR;
            return searchRecursively(key,array,0,array.length-1, false);
        }

        private static int searchRecursively(Segment key, Segment[] array, int low, int high, boolean eq) {
            if (low > high) return eq ? high : low;
            int mid = low + (high - low)/2;
            int compare = comparator.compare(key,array[mid]);

            if (compare < 0 || (eq && compare == 0))
                return searchRecursively(key, array, low, mid - 1, eq);
            else
                return searchRecursively(key, array, mid + 1, high, eq);
        }

        static int countLines(int point, Segment[] linesSortedByStart, Segment[] linesSortedByEnd) {
            Segment p = new Segment(point, point);
            int lineLength = linesSortedByStart.length;
            int fl = Segment.indexOfFirstLess(p,linesSortedByEnd) + 1;
            int fg = Segment.indexOfFirstGreater(p,linesSortedByStart);

            if (fl > lineLength) fl = 0;

            if (fg < 0) fg = 0;
            else fg = lineLength - fg;

            return lineLength - fl - fg;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new ByteArrayInputStream(("2 3\n" +
                "0 5\n" +
                "7 10\n" +
                "1 6 11"
        ).getBytes()));

        int nl = sc.nextInt(), np = sc.nextInt();

        Segment[] sortedByStart = new Segment[nl];

        for (int i = 0; i < nl; i++)
            sortedByStart[i] = new Segment(sc.nextInt(), sc.nextInt());

        QuickSort.eliminatedSort(sortedByStart,0,sortedByStart.length - 1,Segment.START_COMPARATOR);
        Segment[] sortedByEnd = sortedByStart.clone();
        QuickSort.eliminatedSort(sortedByEnd,0,sortedByEnd.length - 1,Segment.END_COMPARATOR);

        for (int i = 0; i < np; i++)
            System.out.println(Segment.countLines(sc.nextInt(),sortedByStart, sortedByEnd) + " ");
    }
}
