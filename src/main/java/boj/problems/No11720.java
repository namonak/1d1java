package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class No11720 {
    public static String solve(BufferedReader input) throws IOException {
        int strLen = Integer.parseInt(Objects.requireNonNull(input.readLine()));
        String inputStr = Objects.requireNonNull(input.readLine());
        int result = 0;

        for (int i = 0; i < strLen; i++) {
            result += Integer.parseInt(String.valueOf(inputStr.charAt(i)));
        }

        return String.valueOf(result);
    }
}
