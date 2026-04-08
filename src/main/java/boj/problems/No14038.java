package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No14038 {
    public static String solve(BufferedReader input) throws IOException {
        int wins = 0;

        for (int i = 0; i < 6; i++) {
            String result = input.readLine();
            if ("W".equals(result)) {
                wins++;
            }
        }

        if (wins >= 5) {
            return "1";
        } else if (wins >= 3) {
            return "2";
        } else if (wins >= 1) {
            return "3";
        } else {
            return "-1";
        }
    }
}
