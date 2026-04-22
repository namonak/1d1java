package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No1019 {
    public static String solve(BufferedReader input) throws IOException {
        long n = Long.parseLong(input.readLine().trim());
        long[] counts = new long[10];

        long factor = 1;
        while (factor <= n) {
            long higher = n / (factor * 10);
            long current = (n / factor) % 10;
            long lower = n % factor;

            // 숫자 0 처리 (leading zero 보정 필요)
            if (higher > 0) {
                if (current == 0) {
                    counts[0] += (higher - 1) * factor + (lower + 1);
                } else {
                    counts[0] += higher * factor;
                }
            }

            // 숫자 1 ~ 9 처리
            for (int digit = 1; digit <= 9; digit++) {
                if (current > digit) {
                    counts[digit] += (higher + 1) * factor;
                } else if (current == digit) {
                    counts[digit] += higher * factor + (lower + 1);
                } else {
                    counts[digit] += higher * factor;
                }
            }

            factor *= 10;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (i > 0) {
                answer.append(' ');
            }
            answer.append(counts[i]);
        }

        return answer.toString();
    }
}
