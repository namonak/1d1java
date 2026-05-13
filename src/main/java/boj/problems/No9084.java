package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class No9084 {
    public static String solve(BufferedReader input) throws IOException {

        int testCaseCount = Integer.parseInt(Objects.requireNonNull(input.readLine()).trim());
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[10001]; // 최대 M = 10000

        while (testCaseCount-- > 0) {
            int n = Integer.parseInt(Objects.requireNonNull(input.readLine()).trim());

            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(Objects.requireNonNull(input.readLine()));
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(Objects.requireNonNull(input.readLine()).trim());

            // dp 초기화
            for (int i = 0; i <= m; i++) {
                dp[i] = 0;
            }
            dp[0] = 1;

            // DP 수행 (조합 방식)
            for (int coin : coins) {
                for (int i = coin; i <= m; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            sb.append(dp[m]).append('\n');
        }

        return sb.toString();
    }
}
