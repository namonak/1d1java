package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No3003 {
    public static String solve(BufferedReader input) throws IOException {
        String[] inputString = input.readLine().split(" ");
        int[] chess = {1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chess.length; i++) {
            sb.append(chess[i] - Integer.parseInt(inputString[i])).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
