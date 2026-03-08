package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class No1546 {
    public static String solve(BufferedReader input) throws IOException {
        int TestCase = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[TestCase];

        for (int i = 0; i < TestCase; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return String.valueOf(getResult(arr));
    }

    private static float getResult(int[] arr) {
        int maxNum = Arrays.stream(arr).max().getAsInt();
        float result = 0;

        for (int j : arr) {
            if (j <= maxNum) {
                result += j / (float) maxNum * 100;
            }
        }

        return result / arr.length;
    }
}
