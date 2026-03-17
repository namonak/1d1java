package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11066 {

    public static String solve(BufferedReader input) throws IOException {
        int t = Integer.parseInt(input.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(input.readLine());

            int[] sum = new int[k + 1];
            int[][] dp = new int[k + 1][k + 1];

            // DP 배열 초기화 (-1)
            for (int i = 0; i <= k; i++) {
                Arrays.fill(dp[i], -1);
            }

            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            for (int i = 1; i <= k; i++) {
                int file = Integer.parseInt(tokenizer.nextToken());
                sum[i] = sum[i - 1] + file; // 누적 합 계산
            }

            // 재귀 호출 및 결과 저장
            output.append(getMinCost(1, k, dp, sum)).append("\n");
        }

        return output.toString().trim();
    }

    // 재귀 함수 정의 (메모이제이션)
    private static int getMinCost(int start, int end, int[][] dp, int[] sum) {
        // 기저 사례: 파일이 하나면 합칠 비용이 0
        if (start == end) {
            return 0;
        }

        // 이미 계산된 값이 있으면 반환
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int minCost = Integer.MAX_VALUE;

        // k를 기준으로 두 구간으로 나누어 최소 비용 탐색
        for (int k = start; k < end; k++) {
            int cost =
                    getMinCost(start, k, dp, sum)
                            + getMinCost(k + 1, end, dp, sum)
                            + (sum[end] - sum[start - 1]);
            minCost = Math.min(minCost, cost);
        }

        dp[start][end] = minCost;
        return minCost;
    }
}
