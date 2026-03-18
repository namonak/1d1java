package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No11066 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(input.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(input.readLine());

            long[] prefix = new long[k + 1];
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 1; i <= k; i++) {
                prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
            }

            long[][] dp = new long[k + 2][k + 2];
            int[][] opt = new int[k + 2][k + 2];

            for (int i = 1; i <= k; i++) {
                opt[i][i] = i;
            }

            for (int len = 2; len <= k; len++) {
                for (int i = 1; i + len - 1 <= k; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Long.MAX_VALUE;

                    long sum = prefix[j] - prefix[i - 1];

                    int start = opt[i][j - 1];
                    int end = opt[i + 1][j];

                    if (start < i) {
                        start = i;
                    }
                    if (end == 0 || end > j - 1) {
                        end = j - 1;
                    }

                    for (int mid = start; mid <= end; mid++) {
                        long cost = dp[i][mid] + dp[mid + 1][j] + sum;
                        if (cost < dp[i][j]) {
                            dp[i][j] = cost;
                            opt[i][j] = mid;
                        }
                    }
                }
            }

            sb.append(dp[1][k]).append('\n');
        }

        return sb.toString();
    }
}
