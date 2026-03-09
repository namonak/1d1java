package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1085 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        if (st.countTokens() < 4) {
            throw new IllegalArgumentException("Expected 4 integers.");
        }

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        return String.valueOf(getResult(x, y, w, h));
    }

    private static int getResult(int x, int y, int w, int h) {
        int min = Math.min(x, y);
        min = Math.min(min, w - x);
        min = Math.min(min, h - y);

        return min;
    }
}
