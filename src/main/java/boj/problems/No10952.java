package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No10952 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        return getResult(input, sb);
    }

    private static String getResult(BufferedReader input, StringBuilder sb) throws IOException {
        while (true) {
            StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            if (a == 0 && b == 0) {
                break;
            }
            sb.append(a + b).append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
