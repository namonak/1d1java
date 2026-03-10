package swea.problems;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA10806 {

    public static String solve(BufferedReader br) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            long[] A = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(st.nextToken());
            }

            long K = Long.parseLong(br.readLine());

            // 다익스트라 PQ
            PriorityQueue<State> pq = new PriorityQueue<>();
            pq.offer(new State(0L, K));

            // 방문 체크: 동일 K에 대해 더 큰 cost라면 의미 없음
            // long 범위이므로 HashSet 사용
            HashSet<Long> visited = new HashSet<>(4096);

            long answer = -1;

            while (!pq.isEmpty()) {
                State cur = pq.poll();
                long cost = cur.cost;
                long k = cur.k;

                if (!visited.add(k)) continue;

                if (k == 0) {
                    answer = cost;
                    break;
                }

                // 1. 남은 k를 전부 1씩 빼서(=X+=D) 0까지 가는 경우
                pq.offer(new State(cost + k, 0));

                // 2. 각 Ai에 대해 나누며 Backward Search
                for (long ai : A) {
                    long nextK = k / ai;
                    long extra = k % ai;
                    long nextCost = cost + extra;
                    pq.offer(new State(nextCost, nextK));
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        return sb.toString();
    }

    private static class State implements Comparable<State> {
        long cost;
        long k;

        State(long cost, long k) {
            this.cost = cost;
            this.k = k;
        }

        public int compareTo(State o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}
