package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No10430 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        return getResult(a, b, c);
    }

    private static String getResult(int a, int b, int c) {
        if (c == 0) {
            throw new IllegalArgumentException("C must not be zero.");
        }

        return (a + b) % c
                + "\n"
                + ((a % c) + (b % c)) % c
                + "\n"
                + (a * b) % c
                + "\n"
                + ((a % c) * (b % c)) % c;
    }
}
