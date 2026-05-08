package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class No3067 {

    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(Objects.requireNonNull(input.readLine()).trim());

        while (testCaseCount-- > 0) {
            int n = Integer.parseInt(Objects.requireNonNull(input.readLine()).trim());

            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(Objects.requireNonNull(input.readLine()));
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(Objects.requireNonNull(input.readLine()).trim());

            // dp[i] : 금액 i를 만드는 방법의 수
            int[] dp = new int[m + 1];
            dp[0] = 1; // 기저 조건

            // 동전을 바깥 루프에 두어 조합을 계산
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
