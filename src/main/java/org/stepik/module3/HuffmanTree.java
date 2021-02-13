package org.stepik.module3;

import java.util.*;

public class HuffmanTree {

    private Node root;
    private final Map<Character, String> codes = new HashMap<>();
    private final Map<Character, Integer> frequencies = new LinkedHashMap<>();
    private final String text;

    public HuffmanTree(String text) {
        this.text = text;
        computeFrequencies(text);


        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (Character key : frequencies.keySet()) {
            queue.add(new Node(null,null, frequencies.get(key), key));
        }

        buildTree(queue);
        traverse(root, new StringBuilder());
    }

    public String compressedText() {
        StringBuilder compressed = new StringBuilder();
        text.chars().forEach(value -> compressed.append(codeOf((char) value)));
        return compressed.toString();
    }

    public void printAllCodes() {
        frequencies.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + codeOf(entry.getKey())));
    }

    public int numberOfElements() {
        return frequencies.size();
    }

    private void computeFrequencies(String text) {
        text.chars().forEach(value -> {
            char ch = (char) value;
            if (frequencies.containsKey(ch))
                frequencies.put(ch, frequencies.get(ch) + 1);
            else
                frequencies.put(ch, 1);
        });
    }

    private void buildTree(PriorityQueue<Node> queue) {
        if (queue.size() == 1) {
            root = new Node(null,null,queue.peek().freq, queue.peek().charValue);
        } else while (queue.size() > 1) {
            HuffmanTree.Node min1 = queue.poll();
            HuffmanTree.Node min2 = queue.poll();
            combine(min1, min2);
            queue.add(root);
        }
    }

    private static class Node
            implements Comparable<Node> {
        Node left;
        Node right;

        int freq;
        char charValue;

        public Node(Node left, Node right, int freq, char charValue) {
            this.left = left;
            this.right = right;
            this.freq = freq;
            this.charValue = charValue;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.freq, o.freq);
        }
    }

    private void combine(Node root1, Node root2) {
        Node l = root1, r = root2;
        int compare = root1.compareTo(root2);
        if (compare > 0 || (l == root && compare == 0)) {
            l = root2;
            r = root1;
        }

        root = new Node(l,r,l.freq + r.freq, '~');
    }

    private void traverse(Node root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            codes.put(root.charValue, sb.toString());
            return;
        }

        traverse(root.left, new StringBuilder(sb).append('0'));
        traverse(root.right, new StringBuilder(sb).append('1'));
    }

    private String codeOf(char ch) {
        if (frequencies.size() == 1) return "0";
        return codes.get(ch);
    }
}