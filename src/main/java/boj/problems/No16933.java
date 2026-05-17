package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.StringTokenizer;

public class No16933 {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private static class State {
        int r;
        int c;
        int k;
        int dist;

        State(int r, int c, int k, int dist) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = dist;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(Objects.requireNonNull(input.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Objects.requireNonNull(input.readLine()).toCharArray();
        }

        // 🔥 visited[r][c][remainingBreak][day/night]
        // day = 0 → 밤, 1 → 낮
        boolean[][][][] visited = new boolean[n][m][k + 1][2];
        ArrayDeque<State> q = new ArrayDeque<>();

        visited[0][0][k][1] = true; // dist = 1 → 낮
        q.offer(new State(0, 0, k, 1));

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.r == n - 1 && cur.c == m - 1) {
                return Integer.toString(cur.dist);
            }

            int day = cur.dist & 1; // 1 = 낮, 0 = 밤

            // 4방 이동
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + DR[d];
                int nc = cur.c + DC[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                // 빈 칸
                if (map[nr][nc] == '0') {
                    if (!visited[nr][nc][cur.k][1 - day]) {
                        visited[nr][nc][cur.k][1 - day] = true;
                        q.offer(new State(nr, nc, cur.k, cur.dist + 1));
                    }
                }
                // 벽
                else if (cur.k > 0
                        && day == 1
                        && !visited[nr][nc][cur.k - 1][1 - day]) { // 낮일 때만 부술 수 있음
                    visited[nr][nc][cur.k - 1][1 - day] = true;
                    q.offer(new State(nr, nc, cur.k - 1, cur.dist + 1));
                }
            }

            // WAIT (밤일 때만)
            if (day == 0 && !visited[cur.r][cur.c][cur.k][1 - day]) { // 밤
                visited[cur.r][cur.c][cur.k][1 - day] = true;
                q.offer(new State(cur.r, cur.c, cur.k, cur.dist + 1));
            }
        }

        return "-1";
    }
}
