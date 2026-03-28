package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No14889 {
    static int N;
    static int[][] W; // S[i][j] + S[j][i] 를 미리 계산
    static boolean[] selected;
    static int min;

    public static String solve(BufferedReader input) throws IOException {
        N = Integer.parseInt(input.readLine().trim());

        int[][] S = new int[N][N];
        selected = new boolean[N];

        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // W 미리 계산 (i < j만 의미 있음)
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                W[i][j] = S[i][j] + S[j][i];
            }
        }

        // 0번 사람은 스타트 팀 고정 (중복 제거)
        min = Integer.MAX_VALUE;
        selected[0] = true;
        dfs(1, 1);

        return String.valueOf(min);
    }

    static void dfs(int start, int count) {

        // 이미 최소가 0이면 더 볼 필요 없음
        if (min == 0) return;

        // 팀 완성
        if (count == N / 2) {
            int startTeam = 0;
            int linkTeam = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        startTeam += W[i][j];
                    } else if (!selected[i] && !selected[j]) {
                        linkTeam += W[i][j];
                    }
                }
            }

            min = Math.min(min, Math.abs(startTeam - linkTeam));
            return;
        }

        // 가지치기
        if (N - start < (N / 2 - count)) return;

        for (int i = start; i < N; i++) {
            selected[i] = true;
            dfs(i + 1, count + 1);
            selected[i] = false;
        }
    }
}
