package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No9498 {
    public static String solve(BufferedReader input) throws IOException {
        int score = Integer.parseInt(input.readLine());

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
