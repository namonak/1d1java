package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class No2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int[] arr = makeArray(input);

        int maxIdx = getMaxIndex(arr);

        output.write(arr[maxIdx] + "\n" + (maxIdx + 1));
    }

    private static int getMaxIndex(int[] arr) {
        int maxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static int[] makeArray(BufferedReader input) throws IOException {
        List<Integer> List = new ArrayList<>();
        String tmp = null;

        while ((tmp = input.readLine()) != null) {
            List.add(Integer.parseInt(tmp));
        }

        return List.stream().mapToInt(i -> i).toArray();
    }
}
