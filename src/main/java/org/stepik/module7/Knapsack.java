package org.stepik.module7;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Knapsack {
    private static final byte[] input = "10 3\n1 4 8".getBytes();

    // solution for non repeatable items
    public static int maxCost(int[] weights, int W) {
        int[][] D = new int[weights.length + 1][W + 1];

        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                D[i][j] = D[i - 1][j];

                if (weights[i - 1] <= j) {
                    D[i][j] = Math.max(D[i][j], D[i - 1][j - weights[i - 1]] + weights[i - 1]);
                }
            }
        }
//        Arrays.stream(D).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return D[weights.length][W];
    }

    public static int maxCostRecursively(int[] weights, int W) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = maxCostRecursively(map, W, weights);
        map.forEach((k,v) -> System.out.println(k + " " + v));
        return i;
    }

    // solution for repeatable items
    public static int maxCostRecursively(Map<Integer, Integer> map, int Weight, int[] weights) {
        if (map.containsKey(Weight)) {
            return map.get(Weight);
        }

        int v = 0;
        for (int w : weights) {
            if (w <= Weight) {
                int a = maxCostRecursively(map, Weight - w, weights) + w;
                v = Math.max(v, a);
            }
        }

        map.put(Weight, v);
        return v;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new ByteArrayInputStream(input));

        int W = sc.nextInt();
        int[] items = new int[sc.nextInt()];

        for (int i = 0; i < items.length; i++) {
            items[i] = sc.nextInt();
        }

//      Arrays.stream(items).forEach(i -> System.out.print(i + " "));
        System.out.println(maxCost(items, W));
        System.out.println(maxCostRecursively(items, W));
    }
}
