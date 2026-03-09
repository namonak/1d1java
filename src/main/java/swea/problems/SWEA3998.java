package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA3998 {
    static int[] tree = new int[100005];
    static int N;

    static void update(int i, int diff) {
        while (i <= N) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    static long sum(int i) {
        long ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }

    public static String solve(BufferedReader br) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            for (int i = 1; i <= N; i++) {
                tree[i] = 0;
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long inversionCount = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());

                inversionCount += (sum(N) - sum(num));

                update(num, 1);
            }

            sb.append("#").append(tc).append(" ").append(inversionCount).append("\n");
        }

        return sb.toString().trim();
    }
}
