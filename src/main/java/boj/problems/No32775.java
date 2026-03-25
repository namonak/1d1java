package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No32775 {
    public static String solve(BufferedReader input) throws IOException {
        int s = Integer.parseInt(input.readLine());
        int f = Integer.parseInt(input.readLine());

        if (s > f) {
            return "flight";
        } else {
            return "high speed rail";
        }
    }
}
