package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA7465 {
    private static final int[] parent = new int[105];

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }

    public static String solve(BufferedReader br) throws Exception {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            int groupCount = n;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (union(a, b)) {
                    groupCount--;
                }
            }
            sb.append("#").append(tc).append(" ").append(groupCount).append("\n");
        }

        return sb.toString().trim();
    }
}
