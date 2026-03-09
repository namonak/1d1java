package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No10869 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        return getResult(a, b);
    }

    private static String getResult(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b must not be zero.");
        }

        String result = "";

        result += a + b + "\n";
        result += a - b + "\n";
        result += a * b + "\n";
        result += a / b + "\n";
        result += a % b;

        return result;
    }
}
