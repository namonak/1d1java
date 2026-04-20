package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No1206 {
    private static final int MAX_PEOPLE = 1000;
    private static final int SCALE = 1000;

    public static String solve(BufferedReader input) throws IOException {
        int questionCount = Integer.parseInt(input.readLine());
        int[] truncatedAverages = new int[questionCount];

        for (int i = 0; i < questionCount; i++) {
            truncatedAverages[i] = parseScaledValue(input.readLine());
        }

        for (int peopleCount = 1; peopleCount <= MAX_PEOPLE; peopleCount++) {
            if (isPossiblePeopleCount(truncatedAverages, peopleCount)) {
                return String.valueOf(peopleCount);
            }
        }

        // 문제 조건상 항상 답이 존재합니다.
        throw new IllegalStateException("No valid answer found.");
    }

    private static boolean isPossiblePeopleCount(int[] truncatedAverages, int peopleCount) {
        for (int scaledAverage : truncatedAverages) {
            long minSum = (long) scaledAverage * peopleCount;
            long maxSumExclusive = (long) (scaledAverage + 1) * peopleCount;

            long left = ceilDiv(minSum, SCALE);
            long right = (maxSumExclusive - 1) / SCALE;

            if (left > right) {
                return false;
            }
        }

        return true;
    }

    private static long ceilDiv(long value, long divisor) {
        return (value + divisor - 1) / divisor;
    }

    private static int parseScaledValue(String value) {
        String[] parts = value.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);
        int fractionalPart = Integer.parseInt(parts[1]);
        return integerPart * SCALE + fractionalPart;
    }
}
