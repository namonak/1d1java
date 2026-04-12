package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No32458 {
    public static String solve(BufferedReader input) throws IOException {
        String line = input.readLine();

        if (line == null || line.isEmpty()) {
            return "";
        }

        int dotIndex = line.indexOf('.');
        if (dotIndex != -1) {
            return line.substring(0, dotIndex);
        }

        return line;
    }
}
