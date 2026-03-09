package swea.problems;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA5656 {
    static int N, W, H;
    static int answer;
    static int[][] original;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static String solve(BufferedReader br) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            original = new int[H][W];

            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    original[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            answer = Integer.MAX_VALUE;
            dfs(0, original);

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        return sb.toString().trim();
    }

    static void dfs(int depth, int[][] map) {
        if (answer == 0) return;

        if (depth == N) {
            answer = Math.min(answer, count(map));
            return;
        }

        for (int col = 0; col < W; col++) {

            int row = findTop(map, col);
            if (row == -1) {
                dfs(depth + 1, map);
                continue;
            }

            int[][] copy = copyMap(map);

            boom(copy, row, col);
            gravity(copy);

            dfs(depth + 1, copy);
        }
    }

    static int findTop(int[][] map, int col) {
        for (int r = 0; r < H; r++) {
            if (map[r][col] > 0) return r;
        }
        return -1;
    }

    static void boom(int[][] map, int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int power = map[sr][sc];
        q.offer(new int[] {sr, sc, power});
        map[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], p = cur[2];

            if (p <= 1) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r;
                int nc = c;

                for (int k = 1; k < p; k++) {

                    nr += dr[d];
                    nc += dc[d];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) break;

                    if (map[nr][nc] == 0) continue;

                    int np = map[nr][nc];

                    q.offer(new int[] {nr, nc, np});

                    map[nr][nc] = 0;
                }
            }
        }
    }

    static void gravity(int[][] map) {
        for (int c = 0; c < W; c++) {
            int write = H - 1;

            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] > 0) {
                    map[write][c] = map[r][c];
                    if (write != r) map[r][c] = 0;
                    write--;
                }
            }

            for (int r = write; r >= 0; r--) {
                map[r][c] = 0;
            }
        }
    }

    static int[][] copyMap(int[][] src) {
        int[][] dst = new int[H][W];
        for (int i = 0; i < H; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, W);
        }
        return dst;
    }

    static int count(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] != 0) cnt++;
            }
        }
        return cnt;
    }
}
