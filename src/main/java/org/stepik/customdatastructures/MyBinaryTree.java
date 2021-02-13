package org.stepik.customdatastructures;

public class MyBinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    private static class Node<T> {
        Node<T> left;
        Node<T> right;

        T value;

        public Node(Node<T> left, Node<T> right, T value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public void add(T newVal) {
        Node<T> child = new Node<>(null,null,newVal);
        if (root == null) {
            root = child;
            return;
        }
        Node<T> currentNode = root;

        while (true) {
            while (newVal.compareTo(currentNode.value) <= 0) {
                if (currentNode.left == null) {
                    currentNode.left = child;
                    System.out.println(currentNode.value + "'s left " + newVal);
                    return;
                }
                currentNode = currentNode.left;
            }
            while (newVal.compareTo(currentNode.value) > 0) {
                if (currentNode.right == null) {
                    currentNode.right = child;
                    System.out.println(currentNode.value + "'s right " + newVal);
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public boolean contains(T key) {
        Node<T> currentNode = root;

        while (true) {
            while (key.compareTo(currentNode.value) < 0) {
                if (currentNode.left == null) return false;
                currentNode = currentNode.left;
            }
            while (key.compareTo(currentNode.value) > 0) {
                if (currentNode.right == null) return false;
                currentNode = currentNode.right;
            }

            if (key.compareTo(currentNode.value) == 0) return true;
        }
    }

    public T min() {
        Node<T> currentNode = root;

        while (currentNode.left != null)
            currentNode = currentNode.left;

        return currentNode.value;
    }

    public T max() {
        Node<T> currentNode = root;

        while (currentNode.right != null)
            currentNode = currentNode.right;

        return currentNode.value;
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(5);
        tree.add(7);
        tree.add(3);
//        tree.add(6);
        //tree.add(4);
        tree.add(8);
        tree.add(2);
        tree.add(9);
        tree.add(1);

        System.out.println(tree.contains(5));
        System.out.println(tree.contains(7));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(6));
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(8));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(1));
        System.out.println("=\t=\t=\t=\t=\t=\t=\t=");
        System.out.println(tree.contains(-22));
        System.out.println(tree.contains(10));

        System.out.println("min " + tree.min());
        System.out.println("max " + tree.max());
    }
}
