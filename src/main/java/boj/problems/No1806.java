package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1806 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += numbers[right];

            while (sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= numbers[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "0" : String.valueOf(minLength);
    }
}
