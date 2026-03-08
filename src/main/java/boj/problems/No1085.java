package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No1085 {
    public static String solve(BufferedReader input) throws IOException {
        String[] inputString = input.readLine().split(" ");
        int x = Integer.parseInt(inputString[0]);
        int y = Integer.parseInt(inputString[1]);
        int w = Integer.parseInt(inputString[2]);
        int h = Integer.parseInt(inputString[3]);

        return String.valueOf(getResult(x, y, w, h));
    }

    private static int getResult(int x, int y, int w, int h) {
        int min = Math.min(x, y);
        min = Math.min(min, w - x);
        min = Math.min(min, h - y);

        return min;
    }
}
