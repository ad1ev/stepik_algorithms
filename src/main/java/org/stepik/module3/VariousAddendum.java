package org.stepik.module3;

import java.util.LinkedList;
import java.util.List;

public class VariousAddendum {
    public static void main(String[] args) {
        for (int i = 1; i < 33; i++) {
            run(i);
        }
    }

    static void run(int n) {
        List<Integer> adds = naturalAdds(n);

        System.out.print(n + " = ");
        adds.forEach(i -> System.out.print(" "+i));
        System.out.println();
    }

    static List<Integer> naturalAdds(int n) {
        List<Integer> adds = new LinkedList<>();
        int sum = 0;

        for (int i = 1; i * 2 < n - sum; i++) {
            adds.add(i);
            sum += i;
        }
        adds.add(n - sum);
        return adds;
    }
}
