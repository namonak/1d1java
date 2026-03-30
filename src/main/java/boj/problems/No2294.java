package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2294 {

    public static String solve(BufferedReader input) throws IOException {

        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(input.readLine());
        }

        // dp[i] = i원을 만들기 위한 최소 동전 개수
        int[] dp = new int[k + 1];

        // 초기화
        for (int i = 1; i <= k; i++) {
            dp[i] = k + 1; // 도달 불가능 상태
        }
        dp[0] = 0;

        // 동전 바깥, 금액 안쪽 (오름차순)
        for (int coin : coins) {
            if (coin > k) continue; // 최적화 (불필요 연산 방지)

            for (int i = coin; i <= k; i++) {
                if (dp[i - coin] != k + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return (dp[k] > k) ? "-1" : String.valueOf(dp[k]);
    }
}
