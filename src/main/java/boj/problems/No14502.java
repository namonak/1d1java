package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14502 {
    private static int N, M;
    private static int[][] lab;
    private static final List<int[]> emptyList = new ArrayList<>();
    private static final List<int[]> virusList = new ArrayList<>();

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public static String solve(BufferedReader input) throws IOException {

        // 🔥 상태 초기화 (중요)
        emptyList.clear();
        virusList.clear();
        int emptyCount = 0;

        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(input.readLine());
            for (int c = 0; c < M; c++) {
                lab[r][c] = Integer.parseInt(st.nextToken());

                if (lab[r][c] == 0) {
                    emptyList.add(new int[] {r, c});
                    emptyCount++;
                } else if (lab[r][c] == 2) {
                    virusList.add(new int[] {r, c});
                }
            }
        }

        int maxSafe = 0;
        int K = emptyList.size();

        // 3중 for 조합 생성
        for (int i = 0; i < K - 2; i++) {
            for (int j = i + 1; j < K - 1; j++) {
                for (int k = j + 1; k < K; k++) {

                    int[][] copy = copyLab();

                    int[] p1 = emptyList.get(i);
                    int[] p2 = emptyList.get(j);
                    int[] p3 = emptyList.get(k);

                    copy[p1[0]][p1[1]] = 1;
                    copy[p2[0]][p2[1]] = 1;
                    copy[p3[0]][p3[1]] = 1;

                    int infected = bfs(copy);

                    int safeArea = emptyCount - 3 - infected;
                    maxSafe = Math.max(maxSafe, safeArea);
                }
            }
        }

        return String.valueOf(maxSafe);
    }

    private static int bfs(int[][] copy) {

        Queue<int[]> queue = new ArrayDeque<>();

        for (int[] virus : virusList) {
            queue.offer(new int[] {virus[0], virus[1]});
        }

        int infectedCount = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (copy[nr][nc] == 0) {
                    copy[nr][nc] = 2;
                    infectedCount++;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }

        return infectedCount;
    }

    private static int[][] copyLab() {
        int[][] copy = new int[N][M];
        for (int r = 0; r < N; r++) {
            System.arraycopy(lab[r], 0, copy[r], 0, M);
        }
        return copy;
    }
}
