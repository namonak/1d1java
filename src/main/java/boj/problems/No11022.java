package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No11022 {
    public static String solve(BufferedReader input) throws IOException {
        int testCase = Integer.parseInt(input.readLine());
        StringBuilder tokens = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tokens.append("Case #")
                    .append(i + 1)
                    .append(": ")
                    .append(a)
                    .append(" + ")
                    .append(b)
                    .append(" = ")
                    .append(a + b)
                    .append("\n");
        }
        tokens.setLength(tokens.length() - 1);
        return tokens.toString();
    }
}
