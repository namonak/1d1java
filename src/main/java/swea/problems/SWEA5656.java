package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA5656 {
    static int n;
    static int w;
    static int h;
    static int answer;
    static int[][] original;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static String solve(BufferedReader br) throws IOException {
        int testCaseCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= testCaseCount; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            original = new int[h][w];

            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
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

        if (depth == n) {
            answer = Math.min(answer, count(map));
            return;
        }

        for (int col = 0; col < w; col++) {

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
        for (int r = 0; r < h; r++) {
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
            int r = cur[0];
            int c = cur[1];
            int p = cur[2];

            if (p > 1) {
                spreadExplosion(map, q, r, c, p);
            }
        }
    }

    private static void spreadExplosion(
            int[][] map, ArrayDeque<int[]> q, int row, int col, int power) {
        for (int direction = 0; direction < 4; direction++) {
            spreadExplosionInDirection(map, q, row, col, power, direction);
        }
    }

    private static void spreadExplosionInDirection(
            int[][] map, ArrayDeque<int[]> q, int row, int col, int power, int direction) {
        int nextRow = row;
        int nextCol = col;

        for (int distance = 1; distance < power; distance++) {
            nextRow += dr[direction];
            nextCol += dc[direction];

            if (isOutside(nextRow, nextCol)) {
                return;
            }

            enqueueBrick(map, q, nextRow, nextCol);
        }
    }

    private static void enqueueBrick(int[][] map, ArrayDeque<int[]> q, int row, int col) {
        if (map[row][col] == 0) {
            return;
        }

        q.offer(new int[] {row, col, map[row][col]});
        map[row][col] = 0;
    }

    private static boolean isOutside(int row, int col) {
        return row < 0 || row >= h || col < 0 || col >= w;
    }

    static void gravity(int[][] map) {
        for (int c = 0; c < w; c++) {
            int write = h - 1;

            for (int r = h - 1; r >= 0; r--) {
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
        int[][] dst = new int[h][w];
        for (int i = 0; i < h; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, w);
        }
        return dst;
    }

    static int count(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (map[r][c] != 0) cnt++;
            }
        }
        return cnt;
    }
}
