package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11650 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int[][] arr = makeInput(input, n);

        Arrays.sort(
                arr,
                (e1, e2) -> {
                    if (e1[0] == e2[0]) {
                        return e1[1] - e2[1];
                    }
                    return e1[0] - e2[0];
                });
        return makeOutput(n, arr);
    }

    private static String makeOutput(int n, int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        return sb.toString().trim();
    }

    private static int[][] makeInput(BufferedReader input, int n) throws IOException {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
