package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1495 {

    public static String solve(BufferedReader input) throws Exception {
        FastScanner scanner = new FastScanner(input);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = scanner.nextInt();
        }

        boolean[] prev = new boolean[m + 1];
        prev[s] = true;

        for (int i = 0; i < n; i++) {
            boolean[] next = new boolean[m + 1];
            boolean hasAny = false;
            int d = diff[i];

            for (int v = 0; v <= m; v++) {
                if (!prev[v]) {
                    continue;
                }

                int plus = v + d;
                if (plus <= m) {
                    next[plus] = true;
                    hasAny = true;
                }

                int minus = v - d;
                if (minus >= 0) {
                    next[minus] = true;
                    hasAny = true;
                }
            }

            if (!hasAny) {
                return "-1";
            }

            prev = next;
        }

        for (int v = m; v >= 0; v--) {
            if (prev[v]) {
                return String.valueOf(v);
            }
        }

        return "-1";
    }

    private static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        private FastScanner(BufferedReader br) {
            this.br = br;
        }

        private int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    throw new IOException("입력이 부족합니다.");
                }
                st = new StringTokenizer(line);
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
