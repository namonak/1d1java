package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class No15552 {
    public static String solve(BufferedReader input) throws IOException {
        int testCase = Integer.parseInt(input.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            result.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))
                    .append("\n");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }
}
