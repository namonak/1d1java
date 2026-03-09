package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA5604 {
    public static String solve(BufferedReader br) throws Exception {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long result = sumDigitsRange(A, B);
            sb.append('#').append(tc).append(' ').append(result).append('\n');
        }

        return sb.toString().trim();
    }

    /** [A, B] 구간의 자리수 합 = f(B) - f(A - 1) */
    private static long sumDigitsRange(long A, long B) {
        if (A == 0) return f(B); // f(−1) = 0 처리
        return f(B) - f(A - 1);
    }

    /** f(N): 0부터 N까지의 모든 정수의 '자리수 합'을 계산 시간복잡도 O(log N) */
    private static long f(long N) {
        if (N <= 0) return 0;

        long sum = 0;
        long factor = 1;

        while (factor <= N) {
            long high = N / (factor * 10);
            long cur = (N / factor) % 10;
            long low = N % factor;

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
