package swea.problems;

import java.io.BufferedReader;
import java.util.Objects;

public class SWEA2005 {
    private static int[][] memo;

    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int testCasesCount = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());

        for (int t = 1; t <= testCasesCount; t++) {
            int n = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());

            memo = new int[n][n];

            result.append('#').append(t).append("\n");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    result.append(dp(i, j)).append(" ");
                }
                result.append("\n"); // 줄 바꿈
            }
        }

        return result.toString().trim();
    }

    private static int dp(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }

        if (memo[n][k] != 0) {
            return memo[n][k];
        }

        memo[n][k] = dp(n - 1, k - 1) + dp(n - 1, k);

        return memo[n][k];
    }
}
