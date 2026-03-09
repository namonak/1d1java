package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No3190 {
    // 방향: 오른쪽(0), 아래(1), 왼쪽(2), 위(3)
    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    private static final class Cell {
        private final int row;
        private final int col;

        private Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine()); // 보드 크기
        if (n <= 0) {
            throw new IllegalArgumentException("Board size must be positive.");
        }
        boolean[][] apple = new boolean[n + 1][n + 1];
        boolean[][] occupied = new boolean[n + 1][n + 1];

        int k = Integer.parseInt(input.readLine()); // 사과 수
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (!isInsideBoard(n, r, c)) {
                throw new IllegalArgumentException("Apple position out of board: " + r + ", " + c);
            }
            apple[r][c] = true;
        }

        int l = Integer.parseInt(input.readLine()); // 방향 전환 수
        Map<Integer, Character> turnInfo = new HashMap<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            turnInfo.put(t, d);
        }

        return String.valueOf(simulate(n, apple, occupied, turnInfo));
    }

    private static int simulate(
            int n, boolean[][] apple, boolean[][] occupied, Map<Integer, Character> turnInfo) {
        validateBoardState(n, apple, occupied);

        Deque<Cell> snake = new ArrayDeque<>();
        snake.addLast(new Cell(1, 1)); // initial position
        occupied[1][1] = true;

        int time = 0;
        int dir = 0; // initial direction: right

        while (true) {
            time++;

            Cell head = snake.getLast();
            int nr = head.row + DR[dir];
            int nc = head.col + DC[dir];

            // --- 1. 벽 충돌 체크 ---
            if (!isInsideBoard(n, nr, nc)
                    || !isValidIndex(apple, nr, nc)
                    || !isValidIndex(occupied, nr, nc)) {
                return time;
            }

            // --- 2. 자기 몸 충돌 체크 ---
            if (occupied[nr][nc]) {
                return time;
            }

            // --- 3. 머리 이동 ---
            snake.addLast(new Cell(nr, nc));
            occupied[nr][nc] = true;

            // --- 4. 사과 여부 판단 ---
            if (apple[nr][nc]) {
                // 사과가 있으면 꼬리 유지
                apple[nr][nc] = false;
            } else {
                // 사과 없으면 꼬리 줄이기
                Cell tail = snake.removeFirst();
                if (!isValidIndex(occupied, tail.row, tail.col)) {
                    throw new IllegalStateException("Snake tail is outside of board.");
                }
                occupied[tail.row][tail.col] = false;
            }

            // --- 5. 방향 전환 ---
            Character turn = turnInfo.get(time);
            if (turn != null) {
                if (turn == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }
    }

    private static boolean isInsideBoard(int boardSize, int row, int col) {
        return row >= 1 && row <= boardSize && col >= 1 && col <= boardSize;
    }

    private static boolean isValidIndex(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    private static void validateBoardState(int n, boolean[][] apple, boolean[][] occupied) {
        if (!isInsideBoard(n, 1, 1)) {
            throw new IllegalArgumentException("Invalid board size: " + n);
        }
        if (!isValidIndex(apple, 1, 1) || !isValidIndex(occupied, 1, 1)) {
            throw new IllegalArgumentException("Board arrays do not match the given size.");
        }
    }
}
