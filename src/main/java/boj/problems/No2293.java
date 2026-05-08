package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class No2293 {
    public static String solve(BufferedReader input) throws IOException {
        String[] firstLine = Objects.requireNonNull(input.readLine()).split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(Objects.requireNonNull(input.readLine()));
        }

        int[] dp = new int[k + 1];
        dp[0] = 1; // 0원을 만드는 방법은 1가지 (아무것도 사용하지 않음)

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return String.valueOf(dp[k]);
    }
}
