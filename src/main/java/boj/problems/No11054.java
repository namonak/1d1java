package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No11054 {
    public static String solve(BufferedReader input) throws IOException {
        FastReader reader = new FastReader(input);

        int n = reader.nextInt();
        int[] arr = new int[n];
        int[] inc = new int[n];
        int[] dec = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        // inc[i] = i에서 끝나는 가장 긴 증가 부분 수열의 길이
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        // dec[i] = i에서 시작하는 가장 긴 감소 부분 수열의 길이
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, inc[i] + dec[i] - 1);
        }

        return String.valueOf(answer);
    }

    private static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        private FastReader(BufferedReader br) {
            this.br = br;
        }

        private int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
