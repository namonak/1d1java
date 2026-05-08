package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class No34073 {
    public static String solve(BufferedReader input) throws IOException {
        int wordCount = Integer.parseInt(Objects.requireNonNull(input.readLine()));
        String wordsLine = Objects.requireNonNull(input.readLine());
        String[] words = wordsLine.split(" ");
        StringBuilder result = new StringBuilder(wordsLine.length() + wordCount * "DORO ".length());
        for (String word : words) {
            result.append(word).append("DORO ");
        }
        return result.toString();
    }
}
