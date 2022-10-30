package boj.problems.step5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2566 {
    public static final int MATRIX_LENGTH = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        int maxNum = 0;

        for (int i = 0; i < MATRIX_LENGTH; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            maxNum = getRows(sb, maxNum, i, st);
        }
        return sb.toString();
    }

    private static int getRows(StringBuilder sb, int maxNum, int i, StringTokenizer st) {
        for (int j = 0; j < MATRIX_LENGTH; j++) {
            int num = Integer.parseInt(st.nextToken());
            maxNum = makeResult(sb, maxNum, i, j, num);
        }
        return maxNum;
    }

    private static int makeResult(StringBuilder sb, int maxNum, int i, int j, int num) {
        if (num >= maxNum) {
            sb.setLength(0);
            maxNum = num;
            sb.append(maxNum + "\n").append(i + 1).append(" ").append(j + 1);
        }
        return maxNum;
    }
}
