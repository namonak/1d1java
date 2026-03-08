package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2742 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = n; i > 0; i--) {
            sb.append(i).append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
