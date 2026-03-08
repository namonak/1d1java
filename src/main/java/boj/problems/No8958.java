package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No8958 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String tmp = input.readLine();

            result.append(getResult(tmp)).append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static int getResult(String tmp) {
        int result = 0;
        int rate = 0;

        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == 'X') {
                rate = 0;
                continue;
            }
            rate++;
            result += rate;
        }

        return result;
    }
}
