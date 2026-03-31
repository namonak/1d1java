package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2225 {

    private static final int MOD = 1_000_000_000;

    public static String solve(BufferedReader input) throws IOException {

        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // dp[n][k] = n을 k개의 수로 만드는 경우의 수
        int[][] dp = new int[N + 1][K + 1];

        // 초기 조건
        for (int k = 1; k <= K; k++) {
            dp[0][k] = 1; // 0을 만드는 경우는 항상 1가지
        }

        for (int n = 0; n <= N; n++) {
            dp[n][1] = 1; // 1개로 만드는 경우는 항상 1가지
        }

        // 점화식 적용
        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[n][k] = dp[n][k - 1] + dp[n - 1][k];
                if (dp[n][k] >= MOD) {
                    dp[n][k] -= MOD;
                }
            }
        }

        return String.valueOf(dp[N][K]);
    }
}
