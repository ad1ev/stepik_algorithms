package org.stepik.module3;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class LinesAndPoints {
    static class Line implements Comparable<Line> {
        int L;
        int R;

        Line(int l, int r) {
            L = l;
            R = r;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(R, o.R);
        }

        static List<Integer> countPoints(List<Line> lines) {

            Collections.sort(lines);

            List<Integer> points = new ArrayList<>();

            for (int i = 0; i < lines.size(); ) {
                int r = lines.get(i).R;
                points.add(r);

                while (i < lines.size() && r >= lines.get(i).L) i++;
            }
            return points;
        }

    }

    public static void main(String[] args) {
        Scanner input;
        List<Line> lines = new ArrayList<>();

        InputStream is1 = new ByteArrayInputStream("3\n1 3\n2 5\n3 6".getBytes());
        InputStream is2 = new ByteArrayInputStream("4\n4 7\n1 3\n2 5\n5 6".getBytes());

        input = new Scanner(is1);
        int size = input.nextInt();
        for (int i = 0; i < size; i++) {
            lines.add(new Line(input.nextInt(),input.nextInt()));
        }
        List<Integer> points = Line.countPoints(lines);

        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point+" ");
        }
    }
}
