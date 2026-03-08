package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No10870 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());

        return String.valueOf(getNthFibonacci(n));
    }

    private static int getNthFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
