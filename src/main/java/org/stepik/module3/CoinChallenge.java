package org.stepik.module3;

import java.util.LinkedList;
import java.util.List;

public class CoinChallenge {

    public static void main(String[] args) {
        int[] coins = {25, 10, 6, 1};
        int sum = 49;
        List<Integer> used = new LinkedList<>();

        for (int coin : coins) {
            while (sum >= coin) {
                sum -= coin;
                used.add(coin);
            }
        }

        System.out.println("min " + used.size());
        System.out.println(used);


        sum = 49;
        int c = 0;
        for (int coin : coins) {
            int q = sum / coin;
            sum -= q * coin;
            c += q;
        }

        System.out.println("min " + c);
    }
}
