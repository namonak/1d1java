package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No13306 {
    private static int[] parent; // DSU parent
    private static int[] rank; // union by rank

    private static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression (halving)
            x = parent[x];
        }
        return x;
    }

    private static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return;

        // rank 기반 union
        if (rank[ra] < rank[rb]) {
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());

        // 원래 트리 구조 (1-based)
        int[] par = new int[N + 1];
        par[1] = 1; // root

        for (int i = 2; i <= N; i++) {
            par[i] = Integer.parseInt(input.readLine());
        }

        final int total = (N - 1) + Q; // 전체 명령 수

        // 명령 저장
        int[] type = new int[total];
        int[] A = new int[total];
        int[] B = new int[total];

        // type = 0 → delete (b)
        // type = 1 → query (c, d)
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(input.readLine());
            type[i] = Integer.parseInt(st.nextToken());

            if (type[i] == 0) {
                A[i] = Integer.parseInt(st.nextToken());
            } else {
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }
        }

        // DSU 초기화
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        boolean[] answers = new boolean[Q];
        int qIndex = Q - 1; // 뒤에서부터 바로 인덱싱하여 불필요한 역순 반복을 줄임

        for (int i = total - 1; i >= 0; i--) {
            if (type[i] == 0) {
                int b = A[i];
                union(b, par[b]);
            } else {
                // Connectivity 판별 후 즉시 boolean 결과 저장
                answers[qIndex--] = (find(A[i]) == find(B[i]));
            }
        }

        StringBuilder out = new StringBuilder(Q * 4);
        for (int i = 0; i < Q; i++) {
            out.append(answers[i] ? "YES\n" : "NO\n");
        }

        return out.toString().trim();
    }
}
