package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No8393 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return String.valueOf(sum);
    }
}
