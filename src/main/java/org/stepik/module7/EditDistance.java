package org.stepik.module7;

import java.util.Scanner;

public class EditDistance {
    public static int editDist(String a, String b) {
        int n = a.length() + 1;
        int m = b.length() + 1;
        int[][] len = new int[n][m];

        for (int i = 0; i < n; i++) {
            len[i][0] = i;
        }

        for (int i = 0; i < m; i++) {
            len[0][i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int ins = len[i - 1][j] + 1;
                int del = len[i][j - 1] + 1;
                int rep = len[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1);

                len[i][j] = Math.min(Math.min(ins, del), rep);
            }
        }

        return len[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(editDist("ab", "ab"));
        System.out.println(editDist("short", "ports"));
    }
}
