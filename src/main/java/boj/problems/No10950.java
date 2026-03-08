package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class No10950 {
    static String solve(BufferedReader input) throws IOException {
        int testCase = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))
                    .append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
