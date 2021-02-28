package org.stepik.module5;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class CountLinesFasterSolution {


    private static int countPoint(int p, int[] lPoints, int[] rPoints) {
        int lineLength = lPoints.length;
        int fl = firstLess(p,rPoints) + 1;
        int fg = firstGreat(p,lPoints);

        if (fl > lineLength) fl = 0;

        if (fg < 0) fg = 0;
        else fg = lineLength - fg;

        return lineLength - fl - fg;
    }

    private static int firstLess(int p, int[] rPoints) {
        return binaryFirst(p, rPoints, 0, rPoints.length-1, true);
    }

    private static int firstGreat(int p, int[] lPoints) {
        return binaryFirst(p,lPoints,0,lPoints.length-1, false);
    }

    private static int binaryFirst(int key, int[] points, int low, int high, boolean eq) {
        if (low > high) return eq ? high : low;
        int mid = low + (high - low)/2;

        if (key < points[mid] || (eq && points[mid] == key))
            return binaryFirst(key, points, low, mid-1, eq);
        else
            return binaryFirst(key, points, mid+1, high, eq);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new ByteArrayInputStream(("2 3\n" +
                "0 5\n" +
                "7 10\n" +
                "1 6 11"
        ).getBytes()));

        int segmentsNumber = sc.nextInt();
        int pointsNumber = sc.nextInt();

        int[] leftSegmentPoints = new int[segmentsNumber];
        int[] rightSegmentPoints = new int[segmentsNumber];

        for (int i = 0; i < segmentsNumber; i++) {
            leftSegmentPoints[i] = sc.nextInt();
            rightSegmentPoints[i] = sc.nextInt();
        }

        QuickSort.eliminatedSort(leftSegmentPoints,0,leftSegmentPoints.length-1);
        QuickSort.eliminatedSort(rightSegmentPoints,0,rightSegmentPoints.length-1);

        for (int i = 0; i < pointsNumber; i++) {
            System.out.print(countPoint(sc.nextInt(),leftSegmentPoints,rightSegmentPoints) + " ");
        }
    }
}
