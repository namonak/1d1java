package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class No10000 {

    private static final Comparator<Circle> BY_LEFT_ASC_RIGHT_DESC =
            new Comparator<Circle>() {
                @Override
                public int compare(Circle a, Circle b) {
                    if (a.left != b.left) {
                        return Long.compare(a.left, b.left);
                    }
                    return Long.compare(b.right, a.right);
                }
            };

    private static class Circle {
        long left;
        long right;
        long childWidthSum;

        Circle(long center, long radius) {
            left = center - radius;
            right = center + radius;
        }

        long width() {
            return right - left;
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
        Circle[] circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            circles[i] = new Circle(fs.nextInt(), fs.nextInt());
        }

        Arrays.sort(circles, BY_LEFT_ASC_RIGHT_DESC);

        Circle[] stack = new Circle[n];
        int top = -1;
        long separatedInsideCount = 0L;

        for (Circle circle : circles) {
            while (top >= 0 && stack[top].right < circle.right) {
                if (stack[top].childWidthSum == stack[top].width()) {
                    separatedInsideCount++;
                }
                top--;
            }

            if (top >= 0) {
                stack[top].childWidthSum += circle.width();
            }
            stack[++top] = circle;
        }

        while (top >= 0) {
            if (stack[top].childWidthSum == stack[top].width()) {
                separatedInsideCount++;
            }
            top--;
        }

        return String.valueOf(n + 1L + separatedInsideCount);
    }
}
