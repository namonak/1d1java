package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No3003 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] chess = {1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chess.length; i++) {
            if (!st.hasMoreTokens()) {
                throw new IllegalArgumentException("Expected 6 integers.");
            }
            sb.append(chess[i] - Integer.parseInt(st.nextToken())).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
