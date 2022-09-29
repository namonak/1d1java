package boj.problems.step9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class No1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
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

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
