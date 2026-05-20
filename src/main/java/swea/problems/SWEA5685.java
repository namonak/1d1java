package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class SWEA5685 {
    private static final int MIN = 0;
    private static final int MAX = 20;
    private static final int COUNT = MAX + 1;
    private static final int MOD = 1234567891;

    public static String solve(BufferedReader br) throws IOException {
        StringBuilder result = new StringBuilder();

        int testCaseCount = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());

        for (int t = 1; t <= testCaseCount; t++) {
            int n = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());
            int[] numbers = readNumbers(br, n);
            result.append("#").append(t).append(" ").append(countExpressions(numbers)).append("\n");
        }

        return result.toString().trim();
    }

    private static int[] readNumbers(BufferedReader br, int count) throws IOException {
        int[] numbers = new int[count];
        StringTokenizer st = new StringTokenizer(Objects.requireNonNull(br.readLine()).trim());
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        return numbers;
    }

    private static long countExpressions(int[] numbers) {
        long[][] dp = new long[numbers.length - 1][COUNT];
        dp[0][numbers[0]] = 1L;

        for (int i = 1; i < numbers.length - 1; i++) {
            updateWays(dp, i, numbers[i]);
        }

        return dp[numbers.length - 2][numbers[numbers.length - 1]];
    }

    private static void updateWays(long[][] dp, int index, int currentNum) {
        long[] previous = dp[index - 1];
        long[] current = dp[index];

        for (int prevSum = MIN; prevSum <= MAX; prevSum++) {
            long currentWays = previous[prevSum];
            if (currentWays > 0) {
                addWays(current, prevSum + currentNum, currentWays);
                addWays(current, prevSum - currentNum, currentWays);
            }
        }
    }

    private static void addWays(long[] row, int sum, long ways) {
        if (sum >= MIN && sum <= MAX) {
            row[sum] = (row[sum] + ways) % MOD;
        }
    }
}
