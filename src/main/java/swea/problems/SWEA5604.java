package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA5604 {
    public static String solve(BufferedReader br) throws Exception {
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCaseCount; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long result = sumDigitsRange(a, b);
            sb.append('#').append(tc).append(' ').append(result).append('\n');
        }

        return sb.toString().trim();
    }

    /** [A, B] 구간의 자리수 합 = f(B) - f(A - 1) */
    private static long sumDigitsRange(long a, long b) {
        if (a == 0) return f(b); // f(−1) = 0 처리
        return f(b) - f(a - 1);
    }

    /** f(N): 0부터 N까지의 모든 정수의 '자리수 합'을 계산 시간복잡도 O(log N) */
    private static long f(long n) {
        if (n <= 0) return 0;

        long sum = 0;
        long factor = 1;

        while (factor <= n) {
            long high = n / (factor * 10);
            long cur = (n / factor) % 10;
            long low = n % factor;

            for (int d = 1; d <= 9; d++) {
                long cnt = high * factor;

                if (cur > d) {
                    cnt += factor;
                } else if (cur == d) {
                    cnt += low + 1;
                }

                sum += cnt * d;
            }

            factor *= 10;
        }

        return sum;
    }
}
