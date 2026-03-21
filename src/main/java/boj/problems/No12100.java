package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No12100 {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    private static int n;

    public static String solve(BufferedReader input) throws IOException {
        n = Integer.parseInt(input.readLine());
        int[][] board = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        return String.valueOf(dfs(0, board));
    }

    private static int dfs(int depth, int[][] board) {
        int best = getMaxTile(board);

        if (depth == 5) {
            return best;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] nextBoard = move(board, dir);

            if (isSame(board, nextBoard)) {
                continue;
            }

            best = Math.max(best, dfs(depth + 1, nextBoard));
        }

        return best;
    }

    private static int[][] move(int[][] board, int dir) {
        int[][] nextBoard = new int[n][n];

        for (int idx = 0; idx < n; idx++) {
            int[] line = new int[n];

            for (int i = 0; i < n; i++) {
                switch (dir) {
                    case LEFT:
                        line[i] = board[idx][i];
                        break;
                    case RIGHT:
                        line[i] = board[idx][n - 1 - i];
                        break;
                    case UP:
                        line[i] = board[i][idx];
                        break;
                    case DOWN:
                        line[i] = board[n - 1 - i][idx];
                        break;
                    default:
                        break;
                }
            }

            int[] merged = merge(line);

            for (int i = 0; i < n; i++) {
                switch (dir) {
                    case LEFT:
                        nextBoard[idx][i] = merged[i];
                        break;
                    case RIGHT:
                        nextBoard[idx][n - 1 - i] = merged[i];
                        break;
                    case UP:
                        nextBoard[i][idx] = merged[i];
                        break;
                    case DOWN:
                        nextBoard[n - 1 - i][idx] = merged[i];
                        break;
                    default:
                        break;
                }
            }
        }

        return nextBoard;
    }

    private static int[] merge(int[] line) {
        int[] tmp = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (line[i] != 0) {
                tmp[count++] = line[i];
            }
        }

        int[] merged = new int[n];
        int mergedIdx = 0;
        int i = 0;

        while (i < count) {
            if (i + 1 < count && tmp[i] == tmp[i + 1]) {
                merged[mergedIdx++] = tmp[i] << 1;
                i += 2;
            } else {
                merged[mergedIdx++] = tmp[i];
                i++;
            }
        }

        return merged;
    }

    private static int getMaxTile(int[][] board) {
        int max = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] > max) {
                    max = board[r][c];
                }
            }
        }

        return max;
    }

    private static boolean isSame(int[][] a, int[][] b) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (a[r][c] != b[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}
