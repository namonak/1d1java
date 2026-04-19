package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No1263 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());

        int[][] jobs = new int[n][2]; // [][0] = T, [][1] = S

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        int current = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            current = Math.min(current, jobs[i][1]) - jobs[i][0];
        }

        return String.valueOf(current < 0 ? -1 : current);
    }
}
