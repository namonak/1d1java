package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20061 {
    // 초록 보드: 6행 × 4열
    static int[][] green = new int[6][4];
    // 파란 보드: 4행 × 6열
    static int[][] blue = new int[4][6];
    static int score = 0; // 획득 점수

    public static String solve(BufferedReader input) throws IOException {
        score = 0;
        for (int r = 0; r < 6; r++) Arrays.fill(green[r], 0);
        for (int r = 0; r < 4; r++) Arrays.fill(blue[r], 0);

        int N = Integer.parseInt(input.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dropGreen(t, x, y);
            dropBlue(t, x, y);

            clearGreenLines();
            clearBlueLines();

            removeGreenLightRows();
            removeBlueLightCols();
        }

        return score + "\n" + countBlocks();
    }

    private static void dropGreen(int t, int x, int y) {
        int r = 0;

        if (t == 1) {
            for (int row = 0; row < 6; row++) {
                if (green[row][y] == 1) break; // 충돌
                r = row;
            }
            green[r][y] = 1;

        } else if (t == 2) {
            for (int row = 0; row < 6; row++) {
                if (green[row][y] == 1 || green[row][y + 1] == 1) break;
                r = row;
            }
            green[r][y] = 1;
            green[r][y + 1] = 1;

        } else {
            for (int row = 0; row < 5; row++) {
                if (green[row][y] == 1 || green[row + 1][y] == 1) break;
                r = row;
            }
            green[r][y] = 1;
            green[r + 1][y] = 1;
        }
    }

    private static void dropBlue(int t, int x, int y) {
        int c = 0;

        if (t == 1) {
            for (int col = 0; col < 6; col++) {
                if (blue[x][col] == 1) break;
                c = col;
            }
            blue[x][c] = 1;

        } else if (t == 2) {
            for (int col = 0; col < 6; col++) {
                if (blue[x][col] == 1) break;
                c = col;
            }
            blue[x][c] = 1;
            blue[x][c - 1] = 1;

        } else {
            for (int col = 0; col < 6; col++) {
                if (blue[x][col] == 1 || blue[x + 1][col] == 1) break;
                c = col;
            }
            blue[x][c] = 1;
            blue[x + 1][c] = 1;
        }
    }

    private static void clearGreenLines() {
        for (int r = 5; r >= 2; r--) {
            boolean full = true;
            for (int c = 0; c < 4; c++) {
                if (green[r][c] == 0) {
                    full = false;
                    break;
                }
            }
            if (full) {
                score++;
                // 행 삭제
                for (int row = r; row >= 1; row--) {
                    for (int col = 0; col < 4; col++) {
                        green[row][col] = green[row - 1][col];
                    }
                }
                // 최상단 비우기
                for (int col = 0; col < 4; col++) green[0][col] = 0;

                r++; // 삭제 후 한 번 더 검사 (압축으로 인해 새로운 full row 생길 수 있음)
            }
        }
    }

    private static void clearBlueLines() {
        for (int c = 5; c >= 2; c--) {
            boolean full = true;
            for (int r = 0; r < 4; r++) {
                if (blue[r][c] == 0) {
                    full = false;
                    break;
                }
            }
            if (full) {
                score++;
                // 열 삭제 + 오른쪽으로 밀기
                for (int col = c; col >= 1; col--) {
                    for (int row = 0; row < 4; row++) {
                        blue[row][col] = blue[row][col - 1];
                    }
                }
                // 최좌측 비움
                for (int row = 0; row < 4; row++) blue[row][0] = 0;

                c++; // 새로운 full column 발생 가능성 반영
            }
        }
    }

    // -------------------------------------------------------------------------------------
    //  초록 보드 연한 칸 (0,1행) 처리
    // -------------------------------------------------------------------------------------

    private static void removeGreenLightRows() {
        int cnt = 0;
        for (int r = 0; r <= 1; r++) {
            for (int c = 0; c < 4; c++) {
                if (green[r][c] == 1) {
                    cnt++;
                    break;
                }
            }
        }
        if (cnt == 0) return;

        // 맨 아래 cnt개 행 삭제(4~5행)
        for (int i = 0; i < cnt; i++) {
            for (int r = 5; r >= 1; r--) {
                for (int c = 0; c < 4; c++) {
                    green[r][c] = green[r - 1][c];
                }
            }
            for (int c = 0; c < 4; c++) green[0][c] = 0;
        }
    }

    // -------------------------------------------------------------------------------------
    //  파란 보드 연한 칸 (0,1열) 처리
    // -------------------------------------------------------------------------------------

    private static void removeBlueLightCols() {
        int cnt = 0;
        for (int c = 0; c <= 1; c++) {
            for (int r = 0; r < 4; r++) {
                if (blue[r][c] == 1) {
                    cnt++;
                    break;
                }
            }
        }
        if (cnt == 0) return;

        // 맨 오른쪽 열 cnt개 삭제 (4~5열)
        for (int i = 0; i < cnt; i++) {
            for (int col = 5; col >= 1; col--) {
                for (int row = 0; row < 4; row++) {
                    blue[row][col] = blue[row][col - 1];
                }
            }
            for (int row = 0; row < 4; row++) blue[row][0] = 0;
        }
    }

    private static int countBlocks() {
        int cnt = 0;
        for (int r = 0; r < 6; r++) for (int c = 0; c < 4; c++) cnt += green[r][c];

        for (int r = 0; r < 4; r++) for (int c = 0; c < 6; c++) cnt += blue[r][c];

        return cnt;
    }
}
