package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA11446 {
    public static String solve(BufferedReader br) throws Exception {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long[] candies = new long[n];
            long maxCandy = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                candies[i] = Long.parseLong(st.nextToken());
                maxCandy = Math.max(maxCandy, candies[i]);
            }

            long result = getMaxBags(candies, m, maxCandy);

            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        return sb.toString().trim();
    }

    private static long getMaxBags(long[] candies, long m, long right) {
        long left = 1;
        long answer = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canMakeBags(candies, m, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static boolean canMakeBags(long[] candies, long m, long bagCount) {

        long sum = 0;

        for (long candy : candies) {

            sum += candy / bagCount;

            if (sum >= m) {
                return true;
            }
        }

        return false;
    }
}
