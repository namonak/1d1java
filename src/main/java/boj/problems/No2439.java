package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2439 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
