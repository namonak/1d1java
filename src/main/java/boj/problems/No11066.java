package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No11066 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(input.readLine());

        while (t-- > 0) {
            sb.append(solveCase(input)).append('\n');
        }

        return sb.toString();
    }

    private static long solveCase(BufferedReader input) throws IOException {
        int fileCount = Integer.parseInt(input.readLine());
        long[] prefix = readPrefixSums(input, fileCount);
        return computeMinimumMergeCost(fileCount, prefix);
    }

    private static long[] readPrefixSums(BufferedReader input, int fileCount) throws IOException {
        long[] prefix = new long[fileCount + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= fileCount; i++) {
            prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
        }
        return prefix;
    }

    private static long computeMinimumMergeCost(int fileCount, long[] prefix) {
        long[][] dp = new long[fileCount + 2][fileCount + 2];
        int[][] opt = new int[fileCount + 2][fileCount + 2];

        initializeOptimalSplit(opt, fileCount);
        for (int len = 2; len <= fileCount; len++) {
            fillCostsByLength(dp, opt, prefix, fileCount, len);
        }

        return dp[1][fileCount];
    }

    private static void initializeOptimalSplit(int[][] opt, int fileCount) {
        for (int i = 1; i <= fileCount; i++) {
            opt[i][i] = i;
        }
    }

    private static void fillCostsByLength(
            long[][] dp, int[][] opt, long[] prefix, int fileCount, int len) {
        for (int i = 1; i + len - 1 <= fileCount; i++) {
            updateIntervalCost(dp, opt, prefix, i, i + len - 1);
        }
    }

    private static void updateIntervalCost(
            long[][] dp, int[][] opt, long[] prefix, int start, int end) {
        dp[start][end] = Long.MAX_VALUE;
        long sum = prefix[end] - prefix[start - 1];
        int splitStart = Math.max(opt[start][end - 1], start);
        int splitEnd = normalizeSplitEnd(opt[start + 1][end], end);

        for (int mid = splitStart; mid <= splitEnd; mid++) {
            long cost = dp[start][mid] + dp[mid + 1][end] + sum;
            if (cost < dp[start][end]) {
                dp[start][end] = cost;
                opt[start][end] = mid;
            }
        }
    }

    private static int normalizeSplitEnd(int splitEnd, int intervalEnd) {
        if (splitEnd == 0 || splitEnd > intervalEnd - 1) {
            return intervalEnd - 1;
        }
        return splitEnd;
    }
}
