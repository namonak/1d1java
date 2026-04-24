package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No1725 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());

        long[] heights = new long[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Long.parseLong(input.readLine());
        }

        return String.valueOf(getMaxRectangleArea(heights, n));
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
}
