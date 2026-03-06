package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2738 {
    static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[N][M];
        StringBuilder sb = new StringBuilder();

        makeMatrix(input, N, M, matrixA);

        return getResult(input, N, M, matrixA, sb).trim();
    }

    private static String getResult(
            BufferedReader input, int N, int M, int[][] matrixA, StringBuilder sb)
            throws IOException {
        for (int i = 0; i < N; i++) {
            String[] tmp = input.readLine().split(" ");
            getRowsOfResult(M, sb, tmp, matrixA[i]);
        }

        return sb.toString();
    }

    private static void getRowsOfResult(int M, StringBuilder sb, String[] tmp, int[] matrixA) {
        for (int j = 0; j < M; j++) {
            sb.append((matrixA[j] += Integer.parseInt(tmp[j])) + " ");
            if (j == M - 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append("\n");
    }

    private static void makeMatrix(BufferedReader input, int N, int M, int[][] matrixA)
            throws IOException {
        for (int i = 0; i < N; i++) {
            String[] tmp = input.readLine().split(" ");
            getRowsOfMatrix(M, tmp, matrixA[i]);
        }
    }

    private static void getRowsOfMatrix(int M, String[] tmp, int[] matrixA) {
        for (int j = 0; j < M; j++) {
            matrixA[j] = Integer.parseInt(tmp[j]);
        }
    }
}
