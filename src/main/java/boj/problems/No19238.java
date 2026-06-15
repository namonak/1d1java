package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class No19238 {
    private static int n;
    private static int[][] board;
    private static int[][] passengerStart; // 승객 시작 위치 → passenger id
    private static int taxiR;
    private static int taxiC;

    private static final int[] DR = {-1, 0, 0, 1}; // 상, 좌, 우, 하 (행 우선 탐색 정렬에 도움)
    private static final int[] DC = {0, -1, 1, 0};

    public static String solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        passengerStart = new int[n][n];
        int[][] passengerDest = new int[m + 1][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiR = Integer.parseInt(st.nextToken()) - 1;
        taxiC = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken()) - 1;
            int sc = Integer.parseInt(st.nextToken()) - 1;
            int dr = Integer.parseInt(st.nextToken()) - 1;
            int dc = Integer.parseInt(st.nextToken()) - 1;

            passengerStart[sr][sc] = i;
            passengerDest[i][0] = dr;
            passengerDest[i][1] = dc;
        }

        for (int i = 0; i < m; i++) {

            // 1️. 가장 가까운 승객 찾기
            int[] result = findNearestPassenger();
            if (result.length == 0) return "-1";

            int pr = result[0];
            int pc = result[1];
            int distToPassenger = result[2];

            if (fuel < distToPassenger) return "-1";

            fuel -= distToPassenger;
            taxiR = pr;
            taxiC = pc;

            int passengerId = passengerStart[pr][pc];
            passengerStart[pr][pc] = 0;

            // 2️. 목적지까지 이동
            int distToDest =
                    bfsToDestination(
                            taxiR,
                            taxiC,
                            passengerDest[passengerId][0],
                            passengerDest[passengerId][1]);

            if (distToDest == -1 || fuel < distToDest) return "-1";

            fuel -= distToDest;

            // 도착 성공 → 연료 충전
            fuel += distToDest * 2;

            taxiR = passengerDest[passengerId][0];
            taxiC = passengerDest[passengerId][1];
        }

        return String.valueOf(fuel);
    }

    private static int[] findNearestPassenger() {

        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {taxiR, taxiC, 0});
        visited[taxiR][taxiC] = true;

        int minDist = Integer.MAX_VALUE;
        int targetR = -1;
        int targetC = -1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (dist > minDist) break;

            if (isPreferredPassenger(r, c, dist, targetR, targetC, minDist)) {
                minDist = dist;
                targetR = r;
                targetC = c;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];

                if (canVisit(nr, nc, visited)) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc, dist + 1});
                }
            }
        }

        if (targetR == -1) return new int[0];
        return new int[] {targetR, targetC, minDist};
    }

    private static boolean isPreferredPassenger(
            int row, int column, int distance, int targetRow, int targetColumn, int minDistance) {
        return passengerStart[row][column] != 0
                && (distance < minDistance
                        || (distance == minDistance
                                && (row < targetRow
                                        || (row == targetRow && column < targetColumn))));
    }

    private static int bfsToDestination(int sr, int sc, int dr, int dc) {

        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (r == dr && c == dc) return dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];

                if (canVisit(nr, nc, visited)) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }

    private static boolean canVisit(int r, int c, boolean[][] visited) {
        return r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && board[r][c] != 1;
    }
}
