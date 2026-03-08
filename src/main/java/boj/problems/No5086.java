package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No5086 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder result = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            if (b % a == 0) result.append("factor\n");
            else if (a % b == 0) result.append("multiple\n");
            else result.append("neither\n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
