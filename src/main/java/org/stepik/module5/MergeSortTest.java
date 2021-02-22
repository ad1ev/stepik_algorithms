package org.stepik.module5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MergeSortTest {

    @Test
    void testSortValidation() {
        int[] testArray;
        int[] equalArray;

        testArray = new int[] { 5, 1, 9, 3, 7, 4, 6, 2, 8 };
        equalArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        testArray = new int[] { 4, 3, 4, 3, 4, 3, 4, 3, 4, 3 };
        equalArray = new int[] { 3, 3, 3, 3, 3, 4, 4, 4, 4, 4 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        testArray = new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
        equalArray = new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        testArray = new int[] { 9, 8, 7, 6, 5 };
        equalArray = new int[] { 5, 6, 7, 8, 9 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        testArray = new int[] { 2, 1 };
        equalArray = new int[] { 1, 2 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        equalArray = testArray = new int[] { 1, 2 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        equalArray = testArray = new int[] { 1, 2, 3 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        equalArray = testArray = new int[] { 0, 0, 0, 0 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        equalArray = testArray = new int[] { 1 };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        equalArray = testArray = new int[] { };
        Assertions.assertArrayEquals(MergeSort.sort(testArray), equalArray);

        testArray = null;
        Assertions.assertNull(MergeSort.sort(testArray));
    }
}