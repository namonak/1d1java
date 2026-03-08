package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No14681 {
    public static String solve(BufferedReader input) throws IOException {
        int x = Integer.parseInt(input.readLine());
        int y = Integer.parseInt(input.readLine());

        return String.valueOf(getQuadrant(x, y));
    }

    private static int getQuadrant(int x, int y) {
        if (x > 0 && y > 0) {
            return 1;
        }
        if (x < 0 && y > 0) {
            return 2;
        }
        if (x < 0 && y < 0) {
            return 3;
        }
        return 4;
    }
}
