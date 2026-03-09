package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

class No1003 {
    private static final int MAX_N = 40;
    private static final int[][] dp = new int[MAX_N + 1][2];
    private static boolean isPrecomputed = false;

    public static String solve(BufferedReader input) throws IOException {
        if (!isPrecomputed) {
            precompute();
        }

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(input.readLine().trim());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(input.readLine().trim());
            if (n < 0 || n > MAX_N) {
                throw new IllegalArgumentException("n must be between 0 and 40: " + n);
            }
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        return sb.toString().trim();
    }

    private static void precompute() {
        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= MAX_N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        isPrecomputed = true;
    }
}
