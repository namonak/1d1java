package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2588 {
    public static String solve(BufferedReader input) throws IOException {
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());
        return getResult(a, b);
    }

    private static String getResult(int a, int b) {
        return String.valueOf(a * (b % 10))
                + '\n'
                + a * ((b % 100) / 10)
                + '\n'
                + a * (b / 100)
                + '\n'
                + a * b;
    }
}
