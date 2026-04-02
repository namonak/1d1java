package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No34073 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        String[] words = input.readLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append("DORO ");
        }
        return result.toString();
    }
}
