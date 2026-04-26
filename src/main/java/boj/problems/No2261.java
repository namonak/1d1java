package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class No2261 {

    private static final Comparator<Point> BY_X =
            new Comparator<Point>() {
                @Override
                public int compare(Point a, Point b) {
                    if (a.x != b.x) {
                        return Integer.compare(a.x, b.x);
                    }
                    return Integer.compare(a.y, b.y);
                }
            };

    private static final Comparator<Point> BY_Y =
            new Comparator<Point>() {
                @Override
                public int compare(Point a, Point b) {
                    if (a.y != b.y) {
                        return Integer.compare(a.y, b.y);
                    }
                    return Integer.compare(a.x, b.x);
                }
            };

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class FastScanner {
        private final BufferedReader br;

        FastScanner(BufferedReader br) {
            this.br = br;
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = br.read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = br.read();
            }

            int value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = br.read();
            }

            return value * sign;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        FastScanner fs = new FastScanner(input);

        int n = fs.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(fs.nextInt(), fs.nextInt());
        }

        Arrays.sort(points, BY_X);
        for (int i = 1; i < n; i++) {
            if (points[i - 1].x == points[i].x && points[i - 1].y == points[i].y) {
                return "0";
            }
        }

        long answer = distance(points[0], points[1]);
        TreeSet<Point> candidates = new TreeSet<>(BY_Y);
        candidates.add(points[0]);

        int left = 0;
        for (int right = 1; right < n; right++) {
            Point current = points[right];

            while (left < right) {
                long dx = current.x - points[left].x;
                if (dx * dx < answer) {
                    break;
                }

                candidates.remove(points[left]);
                left++;
            }

            int range = (int) Math.sqrt(answer) + 1;
            Point from = new Point(Integer.MIN_VALUE, current.y - range);
            Point to = new Point(Integer.MAX_VALUE, current.y + range);
            NavigableSet<Point> nearByY = candidates.subSet(from, true, to, true);

            for (Point candidate : nearByY) {
                answer = Math.min(answer, distance(current, candidate));
            }

            candidates.add(current);
        }

        return String.valueOf(answer);
    }

    private static long distance(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }
}
