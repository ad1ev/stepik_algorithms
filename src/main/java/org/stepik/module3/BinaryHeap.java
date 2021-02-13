package org.stepik.module3;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// max-heap

public class BinaryHeap<T extends Comparable<T>> {
    private Object[] tree;
    private int count;

    public BinaryHeap() {
        tree = new Object[20];
    }

    public void add(T value) {
        if (count > tree.length - 5) tree = grow();

        tree[++count] = value;

        int valueIndex = count;
        int parentIndex = valueIndex / 2;

        while (parentIndex > 0 && compareByIndex(valueIndex,parentIndex) > 0) {
            swap(valueIndex, parentIndex);
            valueIndex = parentIndex;
            parentIndex = valueIndex / 2;
        }
    }


    @SuppressWarnings("unchecked")
    public T extractMax() {

        T max = (T) tree[1];
        swap(1, count);
        tree[count--] = null;
        siftDown(1);
        return max;
    }

    private void siftDown(int valIndex) {

        int leftChildIndex = 2 * valIndex;
        int childIndex = maxIndex(leftChildIndex, leftChildIndex + 1);

        while (leftChildIndex <= count && compareByIndex(valIndex,childIndex) < 0) {

            swap(valIndex, childIndex);

            valIndex = childIndex;
            leftChildIndex = 2 * valIndex;
            childIndex = maxIndex(leftChildIndex, leftChildIndex + 1);
        }
    }

    private void siftUp() { }

    private void swap(int i, int j) {
        Object t = tree[i];
        tree[i] = tree[j];
        tree[j] = t;
    }

    private int minIndex(int i, int j) {
        if (j > count) return i;
        T o1 = (T) tree[i];
        return o1.compareTo((T) tree[j]) < 0 ? i : j;
    }

    @SuppressWarnings("unchecked")
    private int maxIndex(int i, int j) {
        if (j > count) return i;
        T o1 = (T) tree[i];
        return o1.compareTo((T) tree[j]) < 0 ? j : i;
    }

    private Object[] grow() {
        Object[] expanded = new Object[tree.length + 20];
        System.arraycopy(tree, 0, expanded, 0, tree.length);
        return expanded;
    }

    @SuppressWarnings("unchecked")
    private int compareByIndex(int i, int j) {
        T o1 = (T) tree[i];
        return o1.compareTo((T) tree[j]);
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
        Scanner sc = new Scanner(new ByteArrayInputStream(input1.getBytes()));

        BinaryHeap<Integer> heap = new BinaryHeap<>();
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

//         System.out.println("Array after addition " + value + Arrays.toString(tree));
