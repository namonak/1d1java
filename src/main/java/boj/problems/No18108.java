package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

class No18108 {
    public static String solve(BufferedReader input) throws IOException {
        int year = Integer.parseInt(input.readLine());

        return String.valueOf(year - 543);
    }
}
