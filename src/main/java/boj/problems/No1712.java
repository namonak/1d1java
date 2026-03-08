package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1712 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        return String.valueOf(getBreakEvenPoint(a, b, c));
    }

    private static int getBreakEvenPoint(int a, int b, int c) {
        if (b >= c) {
            return -1;
        }

        return a / (c - b) + 1;
    }
}
