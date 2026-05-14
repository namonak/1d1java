package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No11320 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(input.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            String line = input.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 0) {
                throw new IllegalArgumentException("Triangle side length must not be zero.");
            }

            // 한 변에 들어가는 작은 삼각형의 개수 n = A / B
            int n = a / b;

            // 필요한 전체 개수는 n의 제곱 (n * n)
            // A, B의 최대값이 1,000이므로 n^2은 최대 1,000,000 (int 범위 내)
            int result = n * n;

            sb.append(result).append("\n");
        }

        return sb.toString();
    }
}
