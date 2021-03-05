package org.stepik.module3;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MaxHeap <T extends Comparable<T>>{
    Object[] tree = new Object[10];
    private int size = 0;

    public void add(T val) {
        if (size > tree.length - 2) tree = grow();
        tree[++size] = val;
        siftUp(size);
    }

    public T extractMax() {
        T max = (T) tree[1];
        swap(1, size);
        tree[size--] = null;
        siftDown(1);
        return max;
    }

    private void siftUp(int index) {
        int parentIndex = index / 2;
        while (parentIndex > 0 && compareByIndex(index, parentIndex) > 0) {
            swap(parentIndex, index);

            index = parentIndex;
            parentIndex = parentIndex / 2;
        }
    }

    private void siftDown(int index) {
        int childIndex = index * 2;
        if (childIndex > size) return;
        childIndex = maxChild(childIndex, childIndex + 1);

        while (childIndex <= size && compareByIndex(index, childIndex) < 0) {
            swap(index, childIndex);

            index = childIndex;
            childIndex = childIndex * 2;
            if (childIndex > size) break;
            childIndex = maxChild(childIndex, childIndex + 1);
        }
    }

    private void swap(int i, int j) {
        Object t = tree[i];
        tree[i] = tree[j];
        tree[j] = t;
    }

    private int maxChild(int i, int j) {
        if (j > size) return i;
        return compareByIndex(i, j) < 0 ? j : i;
    }

    private int compareByIndex(int i, int j) {
        T comparable = (T) tree[i];
        return comparable.compareTo((T) tree[j]);
    }

    public int size() {
        return size;
    }

    private Object[] grow() {
        Object[] objects = new Object[size + 50];
        System.arraycopy(tree, 0, objects,0, tree.length);
        return objects;
    }

    public static void main(String[] args) {
        String input1 = "6\n" +
                "Insert 200\n" +
                "Insert 10\n" +
                "ExtractMax\n" +
                "Insert 5\n" +
                "Insert 500\n" +
                "ExtractMax";

        String input2 =
                "Insert 200\n" +
                        "Insert 10\n" +
                        "Insert 5\n" +
                        "Insert 500\n" +
                        "ExtractMax\n" +
                        "ExtractMax\n" +
                        "ExtractMax\n" +
                        "ExtractMax";

        //    500
        //   /   \
        //  200   5
        //  /
        // 10

        Scanner sc = new Scanner(new ByteArrayInputStream(input2.getBytes()));

        MaxHeap<Integer> heap = new MaxHeap<>();
        sc.nextLine();
        while (sc.hasNext()) {
            String command = sc.next();
            if ("Insert".equals(command)) {
                heap.add(sc.nextInt());
            } else {
                System.out.println(heap.extractMax());
            }
        }
    }
}
