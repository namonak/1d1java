package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No21608 {
    private static int n;
    private static int[][] classroom;
    private static boolean[][] like;
    private static int[] order;

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    private static final int[] SCORE = {0, 1, 10, 100, 1000};

    private static class SeatCandidate {
        private final int row;
        private final int col;
        private final int likeCount;
        private final int emptyCount;

        private SeatCandidate(int row, int col, int likeCount, int emptyCount) {
            this.row = row;
            this.col = col;
            this.likeCount = likeCount;
            this.emptyCount = emptyCount;
        }

        private boolean isBetterThan(SeatCandidate other) {
            if (other == null) {
                return true;
            }
            if (likeCount != other.likeCount) {
                return likeCount > other.likeCount;
            }
            if (emptyCount != other.emptyCount) {
                return emptyCount > other.emptyCount;
            }
            if (row != other.row) {
                return row < other.row;
            }
            return col < other.col;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        readInput(input);
        placeStudents();
        return String.valueOf(calculateSatisfaction());
    }

    private static void readInput(BufferedReader input) throws IOException {
        n = Integer.parseInt(input.readLine());
        int totalStudents = n * n;

        classroom = new int[n + 1][n + 1];
        like = new boolean[totalStudents + 1][totalStudents + 1];
        order = new int[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;

            for (int j = 0; j < 4; j++) {
                int liked = Integer.parseInt(st.nextToken());
                like[student][liked] = true;
            }
        }
    }

    private static void placeStudents() {
        for (int student : order) {
            placeStudent(student);
        }
    }

    private static void placeStudent(int student) {
        SeatCandidate best = null;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {

                if (classroom[r][c] != 0) continue;

                SeatCandidate candidate = evaluateSeat(student, r, c);
                if (candidate.isBetterThan(best)) {
                    best = candidate;
                }
            }
        }

        classroom[best.row][best.col] = student;
    }

    private static SeatCandidate evaluateSeat(int student, int row, int col) {
        int likeCount = 0;
        int emptyCount = 0;

        for (int d = 0; d < 4; d++) {
            int nr = row + DR[d];
            int nc = col + DC[d];

            if (!isInside(nr, nc)) continue;

            if (classroom[nr][nc] == 0) {
                emptyCount++;
            } else if (like[student][classroom[nr][nc]]) {
                likeCount++;
            }
        }

        return new SeatCandidate(row, col, likeCount, emptyCount);
    }

    private static int calculateSatisfaction() {
        int totalScore = 0;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {

                int student = classroom[r][c];
                totalScore += SCORE[countLikedNeighbors(student, r, c)];
            }
        }

        return totalScore;
    }

    private static int countLikedNeighbors(int student, int row, int col) {
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int nr = row + DR[d];
            int nc = col + DC[d];

            if (!isInside(nr, nc)) continue;

            int neighbor = classroom[nr][nc];
            if (neighbor != 0 && like[student][neighbor]) {
                count++;
            }
        }

        return count;
    }

    private static boolean isInside(int row, int col) {
        return row >= 1 && row <= n && col >= 1 && col <= n;
    }
}
