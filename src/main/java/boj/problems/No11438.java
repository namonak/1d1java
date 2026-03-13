package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11438 {
    private static final class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        private FastScanner(BufferedReader br) {
            this.br = br;
        }

        private int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    throw new IOException("Unexpected end of input");
                }
                st = new StringTokenizer(line);
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        FastScanner fs = new FastScanner(input);

        int n = fs.nextInt();

        int edgeCount = (n - 1) * 2;
        int[] head = new int[n + 1];
        int[] to = new int[edgeCount];
        int[] next = new int[edgeCount];
        Arrays.fill(head, -1);

        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();

            to[idx] = v;
            next[idx] = head[u];
            head[u] = idx++;

            to[idx] = u;
            next[idx] = head[v];
            head[v] = idx++;
        }

        int log = 1;
        while ((1L << log) <= n) {
            log++;
        }

        int[][] parent = new int[log][n + 1];
        int[] depth = new int[n + 1];
        Arrays.fill(depth, -1);

        int[] queue = new int[n];
        int front = 0;
        int rear = 0;

        depth[1] = 0;
        queue[rear++] = 1;

        while (front < rear) {
            int cur = queue[front++];

            for (int e = head[cur]; e != -1; e = next[e]) {
                int nxt = to[e];
                if (depth[nxt] != -1) {
                    continue;
                }

                depth[nxt] = depth[cur] + 1;
                parent[0][nxt] = cur;
                queue[rear++] = nxt;
            }
        }

        for (int k = 1; k < log; k++) {
            for (int v = 1; v <= n; v++) {
                int mid = parent[k - 1][v];
                parent[k][v] = parent[k - 1][mid];
            }
        }

        int m = fs.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            sb.append(lca(a, b, depth, parent, log)).append('\n');
        }

        return sb.toString().trim();
    }

    private static int lca(int a, int b, int[] depth, int[][] parent, int log) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];
        for (int k = 0; k < log; k++) {
            if ((diff & (1 << k)) != 0) {
                a = parent[k][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int k = log - 1; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return parent[0][a];
    }
}
