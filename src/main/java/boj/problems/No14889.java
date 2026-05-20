package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class No14889 {
    static int n;
    static int[][] w; // S[i][j] + S[j][i] 를 미리 계산
    static boolean[] selected;
    static int min;

    public static String solve(BufferedReader input) throws IOException {
        n = Integer.parseInt(Objects.requireNonNull(input.readLine()).trim());

        int[][] s = new int[n][n];
        selected = new boolean[n];

        // 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(Objects.requireNonNull(input.readLine()));
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // W 미리 계산 (i < j만 의미 있음)
        w = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                w[i][j] = s[i][j] + s[j][i];
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
        if (count == n / 2) {
            updateMinimumDifference();
            return;
        }

        // 가지치기
        if (n - start < (n / 2 - count)) return;

        for (int i = start; i < n; i++) {
            selected[i] = true;
            dfs(i + 1, count + 1);
            selected[i] = false;
        }
    }

    private static void updateMinimumDifference() {
        min = Math.min(min, calculateTeamDifference());
    }

    private static int calculateTeamDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (selected[i] && selected[j]) {
                    startTeam += w[i][j];
                } else if (!selected[i] && !selected[j]) {
                    linkTeam += w[i][j];
                }
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}
