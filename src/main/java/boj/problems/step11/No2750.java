package boj.problems.step11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());

        int[] sorted = insertionSort(makeInput(input, number));

        return makeOutput(number, sorted);
    }

    private static String makeOutput(int number, int[] sorted) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(sorted[i] + "\n");
        }
        return sb.toString();
    }

    private static int[] makeInput(BufferedReader input, int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        return arr;
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            canSwap(arr, j);
        }
        return arr;
    }

    private static void canSwap(int[] arr, int j) {
        while (j > 0 && arr[j - 1] > arr[j]) {
            int tmp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = tmp;
            j--;
        }
    }
}
