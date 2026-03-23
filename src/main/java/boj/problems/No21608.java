package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No21608 {
    private static int N;
    private static int[][] classroom;
    private static boolean[][] like;
    private static int[] order;

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    private static final int[] SCORE = {0, 1, 10, 100, 1000};

    public static String solve(BufferedReader input) throws IOException {
        readInput(input);
        placeStudents();
        return String.valueOf(calculateSatisfaction());
    }

    private static void readInput(BufferedReader input) throws IOException {
        N = Integer.parseInt(input.readLine());
        int totalStudents = N * N;

        classroom = new int[N + 1][N + 1];
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
        int bestLike = -1;
        int bestEmpty = -1;
        int bestRow = Integer.MAX_VALUE;
        int bestCol = Integer.MAX_VALUE;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {

                if (classroom[r][c] != 0) continue;

                int likeCount = 0;
                int emptyCount = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + DR[d];
                    int nc = c + DC[d];

                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;

                    if (classroom[nr][nc] == 0) {
                        emptyCount++;
                    } else if (like[student][classroom[nr][nc]]) {
                        likeCount++;
                    }
                }

                if (likeCount > bestLike
                        || (likeCount == bestLike && emptyCount > bestEmpty)
                        || (likeCount == bestLike && emptyCount == bestEmpty && r < bestRow)
                        || (likeCount == bestLike
                                && emptyCount == bestEmpty
                                && r == bestRow
                                && c < bestCol)) {
                    bestLike = likeCount;
                    bestEmpty = emptyCount;
                    bestRow = r;
                    bestCol = c;
                }
            }
        }

        classroom[bestRow][bestCol] = student;
    }

    private static int calculateSatisfaction() {
        int totalScore = 0;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {

                int student = classroom[r][c];
                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + DR[d];
                    int nc = c + DC[d];

                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;

                    int neighbor = classroom[nr][nc];
                    if (neighbor != 0 && like[student][neighbor]) {
                        count++;
                    }
                }

                totalScore += SCORE[count];
            }
        }

        return totalScore;
    }
}
