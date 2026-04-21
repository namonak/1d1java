package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No6549 {
    public static String solve(BufferedReader input) throws IOException {
        FastReader reader = new FastReader(input);
        StringBuilder answer = new StringBuilder();

        while (true) {
            int n = (int) reader.nextLong();
            if (n == 0) {
                break;
            }

            long[] heights = new long[n];
            for (int i = 0; i < n; i++) {
                heights[i] = reader.nextLong();
            }

            long maxArea = getMaxRectangleArea(heights, n);

            if (answer.length() > 0) {
                answer.append('\n');
            }
            answer.append(maxArea);
        }

        return answer.toString();
    }

    private static long getMaxRectangleArea(long[] heights, int n) {
        int[] stack = new int[n + 1];
        int top = -1;
        long maxArea = 0L;

        for (int i = 0; i <= n; i++) {
            long currentHeight = (i == n) ? 0L : heights[i];

            while (top >= 0 && heights[stack[top]] > currentHeight) {
                long height = heights[stack[top--]];
                int width = (top < 0) ? i : i - stack[top] - 1;
                long area = height * width;
                if (area > maxArea) {
                    maxArea = area;
                }
            }

            stack[++top] = i;
        }

        return maxArea;
    }

    private static class FastReader {
        private final BufferedReader reader;
        private int currentChar = -2;

        private FastReader(BufferedReader reader) {
            this.reader = reader;
        }

        private long nextLong() throws IOException {
            long value = 0;
            int sign = 1;
            int ch = read();

            while (ch <= ' ') {
                ch = read();
            }

            if (ch == '-') {
                sign = -1;
                ch = read();
            }

            while (ch > ' ') {
                value = value * 10 + (ch - '0');
                ch = read();
            }

            return value * sign;
        }

        private int read() throws IOException {
            if (currentChar != -2) {
                int result = currentChar;
                currentChar = -2;
                return result;
            }
            return reader.read();
        }
    }
}
