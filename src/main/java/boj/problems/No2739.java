package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2739 {
    public static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            sb.append(number).append(" * ").append(i).append(" = ").append(number * i).append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
