package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class No1427 {
    public static String solve(BufferedReader input) throws IOException {
        String number = input.readLine();
        Integer[] arr = new Integer[number.length()];

        for (int i = 0; i < number.length(); ++i) {
            arr[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        return computeResult(arr);
    }

    private static String computeResult(Integer[] arr) {
        StringBuilder sb = new StringBuilder();

        for (Integer integer : arr) {
            sb.append(integer);
        }
        return sb.toString();
    }
}
