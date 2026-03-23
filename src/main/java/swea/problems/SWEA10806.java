package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA10806 {
    static long[] A;
    static Map<Long, Long> memo;

    public static String solve(BufferedReader br) throws IOException {

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine().trim());
            A = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(st.nextToken());
            }

            long K = Long.parseLong(br.readLine().trim());

            memo = new HashMap<>();

            long answer = dfs(K);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        return sb.toString();
    }

    static long dfs(long x) {
        if (x == 0) return 0;
        Long cached = memo.get(x);
        if (cached != null) return cached;

        long res = x; // 모두 1로 더하는 경우

        for (long a : A) {
            if (a > x) continue;

            long r = x % a;
            long next = x / a;

            // r은 1씩 더해야 하는 비용
            long candidate = r + dfs(next);

            res = Math.min(res, candidate);
        }

        memo.put(x, res);
        return res;
    }
}
