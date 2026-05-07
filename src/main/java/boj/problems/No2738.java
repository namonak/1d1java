package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2738 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[n][m];
        StringBuilder sb = new StringBuilder();

        makeMatrix(input, n, m, matrixA);

        return getResult(input, n, m, matrixA, sb).trim();
    }

    private static String getResult(
            BufferedReader input, int n, int m, int[][] matrixA, StringBuilder sb)
            throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tmp = input.readLine().split(" ");
            getRowsOfResult(m, sb, tmp, matrixA[i]);
        }

        return sb.toString();
    }

    private static void getRowsOfResult(int m, StringBuilder sb, String[] tmp, int[] matrixA) {
        for (int j = 0; j < m; j++) {
            sb.append((matrixA[j] += Integer.parseInt(tmp[j]))).append(" ");
            if (j == m - 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append("\n");
    }

    private static void makeMatrix(BufferedReader input, int n, int m, int[][] matrixA)
            throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tmp = input.readLine().split(" ");
            getRowsOfMatrix(m, tmp, matrixA[i]);
        }
    }

    private static void getRowsOfMatrix(int m, String[] tmp, int[] matrixA) {
        for (int j = 0; j < m; j++) {
            matrixA[j] = Integer.parseInt(tmp[j]);
        }
    }
}
