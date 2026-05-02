package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2162 {

    private No2162() {}

    private static class Line {
        long x1;
        long y1;
        long x2;
        long y2;

        Line(long x1, long y1, long x2, long y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private static class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int value) {
            if (parent[value] == value) {
                return value;
            }

            parent[value] = find(parent[value]);
            return parent[value];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            if (size[rootA] < size[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];

            return true;
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
        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            lines[i] = new Line(fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt());
        }

        DisjointSet disjointSet = new DisjointSet(n);
        int groupCount = n;
        int maxGroupSize = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersects(lines[i], lines[j]) && disjointSet.union(i, j)) {
                    groupCount--;
                    maxGroupSize = Math.max(maxGroupSize, disjointSet.size[disjointSet.find(i)]);
                }
            }
        }

        return groupCount + "\n" + maxGroupSize;
    }

    private static boolean intersects(Line a, Line b) {
        long ab1 = ccw(a.x1, a.y1, a.x2, a.y2, b.x1, b.y1);
        long ab2 = ccw(a.x1, a.y1, a.x2, a.y2, b.x2, b.y2);
        long cd1 = ccw(b.x1, b.y1, b.x2, b.y2, a.x1, a.y1);
        long cd2 = ccw(b.x1, b.y1, b.x2, b.y2, a.x2, a.y2);

        if (ab1 * ab2 == 0 && cd1 * cd2 == 0) {
            return overlaps(a, b);
        }

        return ab1 * ab2 <= 0 && cd1 * cd2 <= 0;
    }

    private static long ccw(long ax, long ay, long bx, long by, long cx, long cy) {
        long value = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);

        if (value > 0) {
            return 1;
        }
        if (value < 0) {
            return -1;
        }
        return 0;
    }

    private static boolean overlaps(Line a, Line b) {
        return Math.max(Math.min(a.x1, a.x2), Math.min(b.x1, b.x2))
                        <= Math.min(Math.max(a.x1, a.x2), Math.max(b.x1, b.x2))
                && Math.max(Math.min(a.y1, a.y2), Math.min(b.y1, b.y2))
                        <= Math.min(Math.max(a.y1, a.y2), Math.max(b.y1, b.y2));
    }
}
