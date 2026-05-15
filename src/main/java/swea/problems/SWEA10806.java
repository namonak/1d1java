package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class SWEA10806 {
    static long[] a;
    static Map<Long, Long> memo;

    public static String solve(BufferedReader br) throws IOException {

        int testCaseCount = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= testCaseCount; tc++) {

            int n = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());
            a = new long[n];

            StringTokenizer st = new StringTokenizer(Objects.requireNonNull(br.readLine()));
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            long k = Long.parseLong(Objects.requireNonNull(br.readLine()).trim());

            memo = new HashMap<>();

            long answer = dfs(k);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        return sb.toString();
    }

    static long dfs(long x) {
        if (x == 0) return 0;
        Long cached = memo.get(x);
        if (cached != null) return cached;

        long res = x; // 모두 1로 더하는 경우

        for (long value : a) {
            if (value > x) continue;

            long r = x % value;
            long next = x / value;

            // r은 1씩 더해야 하는 비용
            long candidate = r + dfs(next);

            res = Math.min(res, candidate);
        }

        memo.put(x, res);
        return res;
    }
}
