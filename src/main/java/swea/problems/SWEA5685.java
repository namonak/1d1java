package swea.problems;

import java.io.BufferedReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class SWEA5685 {
    private static final int MIN = 0;
    private static final int MAX = 20;
    private static final int COUNT = MAX + 1;
    private static final int MOD = 1234567891;

    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int testCaseCount = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());

        for (int t = 1; t <= testCaseCount; t++) {
            int n = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());
            int[] numbers = new int[n];
            StringTokenizer st = new StringTokenizer(Objects.requireNonNull(br.readLine()).trim());

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            long[][] dp = new long[n - 1][COUNT];

            dp[0][numbers[0]] = 1L;

            for (int i = 1; i < n - 1; i++) {
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

            result.append("#").append(t).append(" ").append(dp[n - 2][numbers[n - 1]]).append("\n");
        }

        return result.toString().trim();
    }
}
