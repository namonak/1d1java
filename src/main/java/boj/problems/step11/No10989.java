package boj.problems.step11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10989 {
    // 0을 포함해야 하므로 1을 더한다.
    public static final int INPUT_LIMIT = 10000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        int[] sorted = countingSort(arr);

        for (int i = 0; i < n; i++) {
            result.append(sorted[i]).append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static int[] countingSort(int[] arr) {
        int[] countingArr = new int[INPUT_LIMIT];
        int[] result = new int[arr.length];
        int maxNum = 0;

        for (int j : arr) {
            countingArr[j]++;
            if (j >= maxNum) maxNum = j;
        }

        for (int i = 0; i <= maxNum - 1; ++i) {
            countingArr[i + 1] =  countingArr[i] + countingArr[i + 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            countingArr[arr[i]]--;
            result[countingArr[arr[i]]] = arr[i];
        }

        return result;
    }
}
