package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA5685 {
    private static final int MIN = 0;
    private static final int MAX = 20;
    private static final int COUNT = MAX + 1;
    private static final int MOD = 1234567891;

    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] numbers = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            long[][] dp = new long[N - 1][COUNT];

            dp[0][numbers[0]] = 1L;

            for (int i = 1; i < N - 1; i++) {
                int currentNum = numbers[i];
                for (int prevSum = MIN; prevSum <= MAX; prevSum++) {
                    if (dp[i - 1][prevSum] == 0) continue;

                    long currentWays = dp[i - 1][prevSum];

                    if (prevSum + currentNum <= MAX) {
                        dp[i][prevSum + currentNum] =
                                (dp[i][prevSum + currentNum] + currentWays) % MOD;
                    }
                    if (prevSum - currentNum >= MIN) {
                        dp[i][prevSum - currentNum] =
                                (dp[i][prevSum - currentNum] + currentWays) % MOD;
                    }
                }
            }

            result.append("#").append(t).append(" ").append(dp[N - 2][numbers[N - 1]]).append("\n");
        }

        return result.toString().trim();
    }
}
