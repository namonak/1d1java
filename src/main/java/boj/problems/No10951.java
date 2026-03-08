package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No10951 {
    public static final int CONVERT_ASCII_TO_INT = 48;

    public static String solve(BufferedReader input) throws IOException {
        StringBuilder tokens = new StringBuilder();
        String str;

        while ((str = input.readLine()) != null) {
            int a = str.charAt(0) - CONVERT_ASCII_TO_INT;
            int b = str.charAt(2) - CONVERT_ASCII_TO_INT;

            tokens.append(a + b).append("\n");
        }
        tokens.setLength(tokens.length() - 1);
        return tokens.toString();
    }
}
