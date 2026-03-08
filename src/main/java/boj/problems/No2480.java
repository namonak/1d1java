package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2480 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        return String.valueOf(getPrizeMoney(a, b, c));
    }

    private static int getPrizeMoney(int a, int b, int c) {
        if (a == b && b == c) {
            return 10000 + (a * 1000);
        }

        if (a == b || a == c) {
            return 1000 + (a * 100);
        }

        if (b == c) {
            return 1000 + (b * 100);
        }

        return getMaximum(a, b, c) * 100;
    }

    private static int getMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }
}
