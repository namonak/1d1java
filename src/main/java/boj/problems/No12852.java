package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No12852 {

    public static String solve(BufferedReader input) throws IOException {
        int N = Integer.parseInt(input.readLine().trim());

        // dp[i]: i를 1로 만드는 최소 연산 횟수
        int[] dp = new int[N + 1];

        // prev[i]: i에 도달하기 직전의 숫자
        int[] prev = new int[N + 1];

        // 초기값
        dp[1] = 0;
        prev[1] = 0;

        // Bottom-Up DP
        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            // 2로 나누는 경우
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }

            // 3으로 나누는 경우
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();

        // 최소 연산 횟수 출력
        sb.append(dp[N]).append('\n');

        // 경로 복원
        int current = N;
        while (current > 0) {
            sb.append(current).append(' ');
            if (current == 1) {
                break;
            }
            current = prev[current];
        }

        return sb.toString().trim();
    }
}
