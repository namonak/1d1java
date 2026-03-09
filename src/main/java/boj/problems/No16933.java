package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class No16933 {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private static class State {
        int r, c, k, dist;

        State(int r, int c, int k, int dist) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = dist;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = input.readLine().toCharArray();
        }

        // 🔥 visited[r][c][remainingBreak][day/night]
        // day = 0 → 밤, 1 → 낮
        boolean[][][][] visited = new boolean[N][M][K + 1][2];
        ArrayDeque<State> q = new ArrayDeque<>();

        visited[0][0][K][1] = true; // dist = 1 → 낮
        q.offer(new State(0, 0, K, 1));

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                return Integer.toString(cur.dist);
            }

            int day = cur.dist & 1; // 1 = 낮, 0 = 밤

            // 4방 이동
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + DR[d];
                int nc = cur.c + DC[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                // 빈 칸
                if (map[nr][nc] == '0') {
                    if (!visited[nr][nc][cur.k][1 - day]) {
                        visited[nr][nc][cur.k][1 - day] = true;
                        q.offer(new State(nr, nc, cur.k, cur.dist + 1));
                    }
                }
                // 벽
                else {
                    if (cur.k > 0 && day == 1) { // 낮일 때만 부술 수 있음
                        if (!visited[nr][nc][cur.k - 1][1 - day]) {
                            visited[nr][nc][cur.k - 1][1 - day] = true;
                            q.offer(new State(nr, nc, cur.k - 1, cur.dist + 1));
                        }
                    }
                }
            }

            // WAIT (밤일 때만)
            if (day == 0) { // 밤
                if (!visited[cur.r][cur.c][cur.k][1 - day]) {
                    visited[cur.r][cur.c][cur.k][1 - day] = true;
                    q.offer(new State(cur.r, cur.c, cur.k, cur.dist + 1));
                }
            }
        }

        return "-1";
    }
}
