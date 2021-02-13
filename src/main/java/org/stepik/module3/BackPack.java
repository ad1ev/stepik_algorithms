package org.stepik.module3;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BackPack {

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream("3 50\n60 20\n100 50\n120 30".getBytes());
        Scanner in = new Scanner(is);

        int s = in.nextInt();
        int W = in.nextInt();

        Map<Double, Integer> subjects = new TreeMap<>((o1, o2) -> Double.compare(o2,o1));

        for (int i = 0; i < s; i++) {
            double cost = in.nextInt();
            int weight = in.nextInt();
//            System.out.println(cost + ":" + weight);
            subjects.put(cost / weight, weight);
        }

        double maxCost = maxCostOf(subjects,W);
        System.out.printf(Locale.US,"%.3f\n",maxCost);
    }

    public static double maxCostOf(Map<Double, Integer> subjects, int W) {
        double maxCost = 0;
        for (Double costPerW : subjects.keySet()) {
            int weight = subjects.get(costPerW);

            if (weight < W) {
                maxCost += weight * costPerW;
                W -= weight;
            } else {
                maxCost += W * costPerW;
                break;
            }
        }
        return maxCost;
    }
}
