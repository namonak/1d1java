package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2438 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
