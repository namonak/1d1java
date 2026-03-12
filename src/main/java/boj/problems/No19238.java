package boj.problems;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class No19238 {
    private static int N, M;
    private static int fuel;
    private static int[][] board;
    private static int[][] passengerStart; // 승객 시작 위치 → passenger id
    private static int[][] passengerDest; // passenger id → 목적지
    private static int taxiR, taxiC;

    private static final int[] DR = {-1, 0, 0, 1}; // 상, 좌, 우, 하 (행 우선 탐색 정렬에 도움)
    private static final int[] DC = {0, -1, 1, 0};

    public static String solve(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        passengerStart = new int[N][N];
        passengerDest = new int[M + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiR = Integer.parseInt(st.nextToken()) - 1;
        taxiC = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken()) - 1;
            int sc = Integer.parseInt(st.nextToken()) - 1;
            int dr = Integer.parseInt(st.nextToken()) - 1;
            int dc = Integer.parseInt(st.nextToken()) - 1;

            passengerStart[sr][sc] = i;
            passengerDest[i][0] = dr;
            passengerDest[i][1] = dc;
        }

        for (int i = 0; i < M; i++) {

            // 1️. 가장 가까운 승객 찾기
            int[] result = findNearestPassenger();
            if (result == null) return "-1";

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

        boolean[][] visited = new boolean[N][N];
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

            if (passengerStart[r][c] != 0) {
                if (dist < minDist
                        || (dist == minDist && (r < targetR || (r == targetR && c < targetC)))) {

                    minDist = dist;
                    targetR = r;
                    targetC = c;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc] || board[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, dist + 1});
            }
        }

        if (targetR == -1) return null;
        return new int[] {targetR, targetC, minDist};
    }

    private static int bfsToDestination(int sr, int sc, int dr, int dc) {

        boolean[][] visited = new boolean[N][N];
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

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc] || board[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, dist + 1});
            }
        }

        return -1;
    }
}
