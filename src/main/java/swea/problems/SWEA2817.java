package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA2817 {
    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            StringTokenizer numberStr = new StringTokenizer(br.readLine().trim());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(numberStr.nextToken());
            }
            int count = findSubsequence(0, 0, numbers, k);

            result.append("#").append(t).append(" ").append(count).append("\n");
        }

        return result.toString().trim();
    }

    private static int findSubsequence(int index, int currentSum, int[] numbers, int k) {
        if (currentSum > k) {
            return 0;
        }

        if (index == numbers.length) {
            return (currentSum == k) ? 1 : 0;
        }

        return findSubsequence(index + 1, currentSum + numbers[index], numbers, k)
                + findSubsequence(index + 1, currentSum, numbers, k);
    }
}
