package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16236 {

    private static final int[] DR = {-1, 0, 0, 1}; // 상, 좌, 우, 하 (우선순위: 상→좌→우→하)
    private static final int[] DC = {0, -1, 1, 0};

    private static final class FishTarget {
        private final int row;
        private final int col;
        private final int distance;

        private FishTarget(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        int N = Integer.parseInt(input.readLine());
        int[][] map = new int[N][N];

        int sr = 0, sc = 0; // 상어 위치
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 9) {
                    sr = r;
                    sc = c;
                    map[r][c] = 0; // 상어 위치 초기화
                }
            }
        }

        int size = 2; // 초기 크기
        int eaten = 0; // 먹은 물고기 수
        int time = 0; // 이동 시간 누적

        while (true) {
            FishTarget target = bfsFindFish(map, N, sr, sc, size);
            if (target == null) break; // 더 이상 먹을 수 없음

            time += target.distance;
            eaten++;

            // 물고기 먹기
            map[target.row][target.col] = 0;
            sr = target.row;
            sc = target.col;

            // 크기 증가 조건
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }

        return String.valueOf(time);
    }

    // BFS로 가장 가까운 먹을 수 있는 물고기 찾기
    private static FishTarget bfsFindFish(int[][] map, int N, int sr, int sc, int size) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        visited[sr][sc] = true;
        q.offer(new int[] {sr, sc, 0});

        int foundDist = -1;
        FishTarget bestTarget = null;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            // 만약 이미 먹을 물고기를 발견했고, 더 먼 거리라면 중단
            if (foundDist != -1 && dist > foundDist) break;

            // 먹을 수 있는 물고기
            if (isEdibleFish(map[r][c], size)) {
                if (bestTarget == null || isHigherPriority(r, c, bestTarget.row, bestTarget.col)) {
                    bestTarget = new FishTarget(r, c, dist);
                    foundDist = dist;
                }
            }

            // BFS 확장
            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];

                if (!canMove(map, visited, N, size, nr, nc)) continue;

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, dist + 1});
            }
        }

        return bestTarget;
    }

    private static boolean canMove(
            int[][] map, boolean[][] visited, int n, int size, int nextRow, int nextCol) {
        if (!isInRange(n, nextRow, nextCol)) {
            return false;
        }
        if (visited[nextRow][nextCol]) {
            return false;
        }
        return map[nextRow][nextCol] <= size;
    }

    private static boolean isInRange(int n, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private static boolean isEdibleFish(int fishSize, int sharkSize) {
        return fishSize != 0 && fishSize < sharkSize;
    }

    private static boolean isHigherPriority(int row, int col, int bestRow, int bestCol) {
        return row < bestRow || (row == bestRow && col < bestCol);
    }
}
