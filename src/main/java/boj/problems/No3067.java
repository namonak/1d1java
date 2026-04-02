package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No3067 {

    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(input.readLine().trim());

        while (T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());

            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(input.readLine().trim());

            // dp[i] : 금액 i를 만드는 방법의 수
            int[] dp = new int[M + 1];
            dp[0] = 1; // 기저 조건

            // 동전을 바깥 루프에 두어 조합을 계산
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
