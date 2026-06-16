package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.StringTokenizer;

public class No16933 {

    private static final int NIGHT = 0;
    private static final int DAY = 1;
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

        char[][] map = readMap(input, n, m);
        return Integer.toString(findShortestPath(map, k));
    }

    private static char[][] readMap(BufferedReader input, int n, int m) throws IOException {
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Objects.requireNonNull(input.readLine()).toCharArray();
        }

        return map;
    }

    private static int findShortestPath(char[][] map, int maxBreakCount) {
        int n = map.length;
        int m = map[0].length;
        boolean[][][][] visited = new boolean[n][m][maxBreakCount + 1][2];
        ArrayDeque<State> q = new ArrayDeque<>();

        visited[0][0][maxBreakCount][DAY] = true;
        q.offer(new State(0, 0, maxBreakCount, 1));

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.r == n - 1 && cur.c == m - 1) {
                return cur.dist;
            }

            offerMoves(map, visited, q, cur);
            offerWaitAtNight(visited, q, cur);
        }

        return -1;
    }

    private static void offerMoves(
            char[][] map, boolean[][][][] visited, ArrayDeque<State> q, State cur) {
        for (int d = 0; d < 4; d++) {
            int nr = cur.r + DR[d];
            int nc = cur.c + DC[d];

            if (isInside(map, nr, nc)) {
                offerMove(map, visited, q, cur, nr, nc);
            }
        }
    }

    private static void offerMove(
            char[][] map,
            boolean[][][][] visited,
            ArrayDeque<State> q,
            State cur,
            int row,
            int col) {
        if (map[row][col] == '0') {
            offerIfUnvisited(visited, q, row, col, cur.k, cur.dist + 1);
            return;
        }

        if (canBreakWall(visited, cur, row, col)) {
            offerIfUnvisited(visited, q, row, col, cur.k - 1, cur.dist + 1);
        }
    }

    private static void offerWaitAtNight(boolean[][][][] visited, ArrayDeque<State> q, State cur) {
        if (getDay(cur.dist) != NIGHT) {
            return;
        }

        offerIfUnvisited(visited, q, cur.r, cur.c, cur.k, cur.dist + 1);
    }

    private static boolean canBreakWall(boolean[][][][] visited, State cur, int row, int col) {
        return cur.k > 0 && getDay(cur.dist) == DAY && !visited[row][col][cur.k - 1][NIGHT];
    }

    private static void offerIfUnvisited(
            boolean[][][][] visited, ArrayDeque<State> q, int row, int col, int k, int dist) {
        int nextDay = getDay(dist);
        if (visited[row][col][k][nextDay]) {
            return;
        }

        visited[row][col][k][nextDay] = true;
        q.offer(new State(row, col, k, dist));
    }

    private static int getDay(int dist) {
        return dist & 1;
    }

    private static boolean isInside(char[][] map, int row, int col) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }
}
