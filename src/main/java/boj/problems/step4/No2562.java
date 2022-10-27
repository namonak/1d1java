package boj.problems.step4;

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

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int[] arr = makeArray(input);

        int maxIdx = getMaxIndex(arr);

        return arr[maxIdx] + "\n" + (maxIdx + 1);
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
        String tmp;

        while ((tmp = input.readLine()) != null) {
            List.add(Integer.parseInt(tmp));
        }

        return List.stream().mapToInt(i -> i).toArray();
    }
}
