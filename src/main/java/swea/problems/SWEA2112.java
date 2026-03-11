package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SWEA2112 {
    private static int D, W, K;
    private static int[][] film; // 원본 필름
    private static int[][] backup; // 변경 전 원본 저장용 (행 단위 복구)
    private static int answer; // 최소 약품 투입 횟수

    // A 막과 B 막 (모든 셀이 0, 모든 셀이 1)
    private static int[] drugA;
    private static int[] drugB;

    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(input.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(input.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            backup = new int[D][W];

            for (int r = 0; r < D; r++) {
                st = new StringTokenizer(input.readLine());
                for (int c = 0; c < W; c++) {
                    film[r][c] = Integer.parseInt(st.nextToken());
                    backup[r][c] = film[r][c];
                }
            }

            // 단순화 최적화: K == 1 → 무조건 통과 → 약품 필요 없음
            if (K == 1) {
                sb.append("#").append(tc).append(" 0\n");
                continue;
            }

            // 미리 all-A_row, all-B_row 생성
            drugA = new int[W];
            drugB = new int[W];
            for (int c = 0; c < W; c++) {
                drugA[c] = 0;
                drugB[c] = 1;
            }

            // 약품 투입 횟수의 최소값을 찾는다.
            answer = Integer.MAX_VALUE;

            // 0회부터 시작하여 점점 증가시키며 검사 (가지치기)
            for (int use = 0; use <= D; use++) {
                if (dfsSelectRows(0, 0, use, new int[use])) break;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        return sb.toString().trim();
    }

    /**
     * 특정 개수(use)의 행을 고르는 조합 생성
     *
     * @param idx : 현재 행 번호 후보
     * @param depth : 선택된 행 수
     * @param use : 목표 선택 수
     * @param selectedRows : 선택된 행 번호 배열
     */
    private static boolean dfsSelectRows(int idx, int depth, int use, int[] selectedRows) {

        // 모든 선택 완료
        if (depth == use) {
            // 선택된 행(reset: 조합만 완료한 상태)에 대해 A/B 배정 시도
            dfsAssign(0, use, selectedRows, new int[use]);
            return answer != Integer.MAX_VALUE; // 정답 찾으면 더 깊은 탐색 필요 없음
        }

        // 더 이상 선택 불가
        if (idx >= D) return false;

        // 가지치기: 남은 행으로도 목표 개수를 못 채우면 중단
        if (D - idx < use - depth) return false;

        // 선택 O
        selectedRows[depth] = idx;
        if (dfsSelectRows(idx + 1, depth + 1, use, selectedRows)) return true;

        // 선택 X
        return dfsSelectRows(idx + 1, depth, use, selectedRows);
    }

    /**
     * 선택된 행들에 대해 A/B 두 가지 상태 배정 (2^use)
     *
     * @param depth : 현재 배정 중인 인덱스
     * @param use : 전체 개수
     * @param rows : 선택된 행들의 번호
     * @param assign : 0 → A, 1 → B
     */
    private static void dfsAssign(int depth, int use, int[] rows, int[] assign) {

        if (answer != Integer.MAX_VALUE) return; // 이미 최소횟수로 정답 얻었음 → 가지치기

        if (depth == use) {
            // 약품 적용
            applyRows(rows, assign);

            // 검사 통과?
            if (check()) {
                answer = use;
            }

            // 원본 복구
            restoreRows(rows);

            return;
        }

        // 해당 행을 A로
        assign[depth] = 0;
        dfsAssign(depth + 1, use, rows, assign);

        // 이미 찾았으면 진행 불필요
        if (answer != Integer.MAX_VALUE) return;

        // 해당 행을 B로
        assign[depth] = 1;
        dfsAssign(depth + 1, use, rows, assign);
    }

    /** 선택된 행들의 값을 A 또는 B 로 치환 */
    private static void applyRows(int[] rows, int[] assign) {
        for (int i = 0; i < rows.length; i++) {
            int r = rows[i];
            int[] src = (assign[i] == 0 ? drugA : drugB);
            System.arraycopy(src, 0, film[r], 0, W);
        }
    }

    /** 변경된 행의 값을 원본(backup)으로 복원 */
    private static void restoreRows(int[] rows) {
        for (int r : rows) {
            System.arraycopy(backup[r], 0, film[r], 0, W);
        }
    }

    /** 열 기준으로 K개 이상 연속된 동일 값이 있는지 확인 */
    private static boolean check() {

        // 각 열을 검사
        for (int c = 0; c < W; c++) {
            boolean ok = false;

            int cnt = 1;

            for (int r = 1; r < D; r++) {
                if (film[r][c] == film[r - 1][c]) {
                    cnt++;
                    if (cnt >= K) {
                        ok = true;
                        break;
                    }
                } else {
                    cnt = 1;
                }
            }

            if (!ok) return false; // 단 하나라도 실패 → 전체 실패
        }

        return true;
    }
}
