package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2753 {
    public static String solve(BufferedReader input) throws IOException {
        int year = Integer.parseInt(input.readLine());

        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return "1";
        }
        return "0";
    }
}
