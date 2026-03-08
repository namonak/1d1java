package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No15683 {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    // CCTV 방향 조합 테이블
    private static final int[][][] DIR = {
        {}, // dummy
        {{0}, {1}, {2}, {3}}, // 1번
        {{0, 2}, {1, 3}}, // 2번
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
        {{0, 1, 2, 3}} // 5번
    };

    private static int N, M;
    private static int[][] cctvList;
    private static int cctvCount;
    private static int minBlind = Integer.MAX_VALUE;

    public static String solve(BufferedReader input) throws IOException {

        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        cctvList = new int[8][3]; // 최대 8개 CCTV (r, c, type 저장)
        cctvCount = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(input.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] >= 1 && map[r][c] <= 5) {
                    cctvList[cctvCount][0] = r;
                    cctvList[cctvCount][1] = c;
                    cctvList[cctvCount][2] = map[r][c];
                    cctvCount++;
                }
            }
        }

        backtrack(0, map);
        return String.valueOf(minBlind);
    }

    // 백트래킹: idx번째 CCTV 처리
    private static void backtrack(int idx, int[][] curMap) {
        if (idx == cctvCount) {
            minBlind = Math.min(minBlind, countBlind(curMap));
            return;
        }

        int r = cctvList[idx][0];
        int c = cctvList[idx][1];
        int type = cctvList[idx][2];

        // 해당 CCTV의 모든 방향 조합 시도
        for (int[] dirs : DIR[type]) {
            int[][] copied = copyMap(curMap); // 안전한 복사

            // dirs에 포함된 모든 방향에 대해 감시 적용
            for (int d : dirs) {
                applyWatch(copied, r, c, d);
            }

            backtrack(idx + 1, copied);
        }
    }

    // 감시 적용 함수
    private static void applyWatch(int[][] map, int r, int c, int dir) {
        int nr = r;
        int nc = c;

        // 다음 칸으로 진행
        while (true) {
            nr += DR[dir];
            nc += DC[dir];

            // ★ 경계 초과 방지: 반드시 즉시 break
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;

            // ★ 벽을 만나면 감시 종료
            if (map[nr][nc] == 6) break;

            // CCTV 통과 가능. 빈 칸만 감시 표시(-1)
            if (map[nr][nc] == 0) {
                map[nr][nc] = -1;
            }
        }
    }

    // 사각지대(0)의 개수 계산
    private static int countBlind(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) cnt++;
            }
        }
        return cnt;
    }

    // 배열 복사 (안전하며 JDK8 기준 충분히 빠름)
    private static int[][] copyMap(int[][] src) {
        int[][] dest = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, M);
        }
        return dest;
    }
}
