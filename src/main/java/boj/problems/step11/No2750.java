package boj.problems.step11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class No2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int[] arr = makeArray(input);
        int[] sorted = insertionSorting(arr);

        for (int i = 0; i < n; i++) {
            output.write(sorted[i] + "\n");
        }
    }

    private static int[] makeArray(BufferedReader input) throws IOException {
        List<Integer> List = new ArrayList<>();
        String tmp = null;

        while ((tmp = input.readLine()) != null) {
            List.add(Integer.parseInt(tmp));
        }

        return List.stream().mapToInt(i -> i).toArray();
    }

    private static int[] insertionSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
        return arr;
    }
}
