package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No17825 {
    private static final int END = 32; // 도착 칸 (특수 처리)
    private static int[] dice = new int[10];
    private static Node[] board = new Node[33];
    private static int[] horse = new int[4]; // 말 4개의 위치 인덱스
    private static int answer = 0;

    private static class Node {
        int score;
        int next; // 기본(빨간) 화살표
        int blue; // 파란 화살표 존재 시 경로 (없으면 -1)

        Node(int score, int next, int blue) {
            this.score = score;
            this.next = next;
            this.blue = blue;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        answer = 0;
        Arrays.fill(horse, 0);
        initBoard();

        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        return String.valueOf(answer);
    }

    /** 게임판 전체 초기화 */
    private static void initBoard() {
        // 기본 경로 (0 → 1 → 2 → ... → 20 → END)
        for (int i = 0; i <= 20; i++) board[i] = new Node(i * 2, i + 1, -1);
        board[21] = new Node(13, 22, -1); // 10에서 파란
        board[22] = new Node(16, 23, -1);
        board[23] = new Node(19, 24, -1);

        board[24] = new Node(25, 30, -1); // 교차점

        board[30] = new Node(30, 31, -1);
        board[31] = new Node(35, 20, -1);

        board[5].blue = 21; // 10의 파란 화살표
        board[10].blue = 25; // 20의 파란 화살표
        board[15].blue = 27; // 30의 파란 화살표

        // 20의 파란 경로
        board[25] = new Node(22, 26, -1);
        board[26] = new Node(24, 24, -1);

        // 30의 파란 경로
        board[27] = new Node(28, 28, -1);
        board[28] = new Node(27, 29, -1);
        board[29] = new Node(26, 24, -1);

        // END node
        board[END] = new Node(0, END, -1);
        board[20].next = END;
        board[24].next = 30;
    }

    /** DFS 완전 탐색 */
    private static void dfs(int depth, int scoreSum) {
        if (depth == 10) {
            answer = Math.max(answer, scoreSum);
            return;
        }

        int diceValue = dice[depth];

        for (int i = 0; i < 4; i++) {
            int start = horse[i];

            if (start == END) continue; // 이미 도착한 말은 이동 불가

            int next = move(start, diceValue);

            // 이동한 칸(next)이 도착 칸이 아니면서 다른 말이 있으면 불가능
            if (next != END && isOccupied(next, i)) continue;

            int original = horse[i];
            horse[i] = next;

            dfs(depth + 1, scoreSum + board[next].score);

            horse[i] = original; // 상태 복원
        }
    }

    /** 말이 해당 칸에 있는지 확인 */
    private static boolean isOccupied(int pos, int horseIdx) {
        for (int i = 0; i < 4; i++) {
            if (i == horseIdx) continue;
            if (horse[i] == pos) return true;
        }
        return false;
    }

    /** 주어진 위치에서 주사위 값만큼 이동 */
    private static int move(int start, int step) {
        int cur = start;

        // 첫 이동 시 파란 화살표 우선
        if (board[cur].blue != -1) {
            cur = board[cur].blue;
            step--;
        } else {
            cur = board[cur].next;
            step--;
        }

        // 나머지는 무조건 빨간 화살표
        while (step > 0 && cur != END) {
            cur = board[cur].next;
            step--;
        }

        return cur;
    }
}
