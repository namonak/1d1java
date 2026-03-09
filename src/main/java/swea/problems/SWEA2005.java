package swea.problems;

import java.io.BufferedReader;

public class SWEA2005 {
    private static int[][] memo;

    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int testCasesCount = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= testCasesCount; t++) {
            int N = Integer.parseInt(br.readLine().trim());

            memo = new int[N][N];

            result.append('#').append(t).append("\n");

            for (int i = 0; i < N; i++) {
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
