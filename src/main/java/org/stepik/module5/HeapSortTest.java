package org.stepik.module5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void heapSort() {
        Integer[] array = {5,3,7,1,9,2,6,4,8};
        Integer[] equal = {1,2,3,4,5,6,7,8,9};
        HeapSort.heapSort(array);
        assertArrayEquals(equal,array);

        array = new Integer[] { 4, 3, 4, 3, 4, 3, 4, 3, 4, 3 };
        equal = new Integer[] { 3, 3, 3, 3, 3, 4, 4, 4, 4, 4 };
        HeapSort.heapSort(array);
        assertArrayEquals(equal,array);

        array = new Integer[] { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
        equal = new Integer[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);

        array = new Integer[] { 9, 8, 7, 6, 5 };
        equal = new Integer[] { 5, 6, 7, 8, 9 };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);

        array = new Integer[] { 2, 1 };
        equal = new Integer[] { 1, 2 };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);


        array = equal = new Integer[] { 1, 2 };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);

        array = equal = new Integer[] { 1, 2, 3 };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);

        array = equal = new Integer[] { 0, 0, 0, 0 };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);

        array = equal = new Integer[]{ 1 };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);

        array = equal = new Integer[] { };
        HeapSort.heapSort(array);
        Assertions.assertArrayEquals(equal, array);
    }
}