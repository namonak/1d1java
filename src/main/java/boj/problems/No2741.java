package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2741 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            result.append(i).append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
