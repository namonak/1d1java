package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16236 {

    private static final int[] DR = {-1, 0, 0, 1}; // 상, 좌, 우, 하 (우선순위: 상→좌→우→하)
    private static final int[] DC = {0, -1, 1, 0};

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
            int[] target = bfsFindFish(map, N, sr, sc, size);
            if (target == null) break; // 더 이상 먹을 수 없음

            int tr = target[0];
            int tc = target[1];
            int dist = target[2];

            time += dist;
            eaten++;

            // 물고기 먹기
            map[tr][tc] = 0;
            sr = tr;
            sc = tc;

            // 크기 증가 조건
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }

        return String.valueOf(time);
    }

    // BFS로 가장 가까운 먹을 수 있는 물고기 찾기
    private static int[] bfsFindFish(int[][] map, int N, int sr, int sc, int size) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        visited[sr][sc] = true;
        q.offer(new int[] {sr, sc, 0});

        int foundDist = -1;
        int fishR = -1, fishC = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            // 만약 이미 먹을 물고기를 발견했고, 더 먼 거리라면 중단
            if (foundDist != -1 && dist > foundDist) break;

            // 먹을 수 있는 물고기
            if (map[r][c] != 0 && map[r][c] < size) {
                if (foundDist == -1) {
                    foundDist = dist;
                    fishR = r;
                    fishC = c;
                } else {
                    // 규칙: 가장 위 → 가장 왼쪽
                    if (r < fishR || (r == fishR && c < fishC)) {
                        fishR = r;
                        fishC = c;
                    }
                }
            }

            // BFS 확장
            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 인덱스 안전
                if (visited[nr][nc]) continue;
                if (map[nr][nc] > size) continue; // 지나갈 수 없음

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, dist + 1});
            }
        }

        if (foundDist == -1) return null; // 먹을 물고기 없음
        return new int[] {fishR, fishC, foundDist};
    }
}
