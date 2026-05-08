package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class No34073 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(Objects.requireNonNull(input.readLine()));
        String[] words = Objects.requireNonNull(input.readLine()).split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append("DORO ");
        }
        return result.toString();
    }
}
