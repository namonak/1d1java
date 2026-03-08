package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2750 {
    public static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());

        int[] sorted = insertionSort(makeInput(input, number));

        return makeOutput(number, sorted);
    }

    private static String makeOutput(int number, int[] sorted) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(sorted[i]).append("\n");
        }
        return sb.toString().trim();
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
            canSwap(arr, i);
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
