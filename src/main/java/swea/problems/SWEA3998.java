package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class SWEA3998 {
    static int[] tree = new int[100005];
    static int n;

    static void update(int i, int diff) {
        while (i <= n) {
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

    public static String solve(BufferedReader br) throws IOException {
        int testCaseCount = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= testCaseCount; tc++) {
            n = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());

            for (int i = 1; i <= n; i++) {
                tree[i] = 0;
            }

            StringTokenizer st = new StringTokenizer(Objects.requireNonNull(br.readLine()), " ");
            long inversionCount = 0;

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());

                inversionCount += (sum(n) - sum(num));

                update(num, 1);
            }

            sb.append("#").append(tc).append(" ").append(inversionCount).append("\n");
        }

        return sb.toString().trim();
    }
}
