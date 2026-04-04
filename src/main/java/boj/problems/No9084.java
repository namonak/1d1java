package boj.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class No9084 {
    public static String solve(BufferedReader input) throws Exception {

        int T = Integer.parseInt(input.readLine().trim());
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[10001]; // 최대 M = 10000

        while (T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());

            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(input.readLine().trim());

            // dp 초기화
            for (int i = 0; i <= M; i++) {
                dp[i] = 0;
            }
            dp[0] = 1;

            // DP 수행 (조합 방식)
            for (int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            sb.append(dp[M]).append('\n');
        }

        return sb.toString();
    }
}
