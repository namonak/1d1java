package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class No1019 {
    public static String solve(BufferedReader input) throws IOException {
        long n = Long.parseLong(Objects.requireNonNull(input.readLine()).trim());
        long[] counts = countDigitsUpTo(n);
        return formatCounts(counts);
    }

    private static long[] countDigitsUpTo(long n) {
        long[] counts = new long[10];

        long factor = 1;
        while (factor <= n) {
            long higher = n / (factor * 10);
            long current = (n / factor) % 10;
            long lower = n % factor;

            counts[0] += countZero(higher, current, lower, factor);
            countNonZeroDigits(counts, higher, current, lower, factor);

            factor *= 10;
        }

        return counts;
    }

    private static long countZero(long higher, long current, long lower, long factor) {
        if (higher == 0) {
            return 0;
        }

        if (current == 0) {
            return (higher - 1) * factor + lower + 1;
        }

        return higher * factor;
    }

    private static void countNonZeroDigits(
            long[] counts, long higher, long current, long lower, long factor) {
        for (int digit = 1; digit <= 9; digit++) {
            counts[digit] += countDigit(digit, higher, current, lower, factor);
        }
    }

    private static long countDigit(int digit, long higher, long current, long lower, long factor) {
        if (current > digit) {
            return (higher + 1) * factor;
        }

        if (current == digit) {
            return higher * factor + lower + 1;
        }

        return higher * factor;
    }

    private static String formatCounts(long[] counts) {
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
