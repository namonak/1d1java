package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2225 {

    private static final int MOD = 1_000_000_000;

    public static String solve(BufferedReader input) throws IOException {

        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // dp[n][k] = n을 k개의 수로 만드는 경우의 수
        int[][] dp = new int[n + 1][k + 1];

        // 초기 조건
        for (int partCount = 1; partCount <= k; partCount++) {
            dp[0][partCount] = 1; // 0을 만드는 경우는 항상 1가지
        }

        for (int sum = 0; sum <= n; sum++) {
            dp[sum][1] = 1; // 1개로 만드는 경우는 항상 1가지
        }

        // 점화식 적용
        for (int partCount = 2; partCount <= k; partCount++) {
            for (int sum = 1; sum <= n; sum++) {
                dp[sum][partCount] = dp[sum][partCount - 1] + dp[sum - 1][partCount];
                if (dp[sum][partCount] >= MOD) {
                    dp[sum][partCount] -= MOD;
                }
            }
        }

        return String.valueOf(dp[n][k]);
    }
}
