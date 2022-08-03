package boj.problems.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class No1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int TestCase = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[TestCase];

        for (int i = 0; i < TestCase; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        output.write(getResult(arr) + "\n");
    }

    private static float getResult(int[] arr) {
        int maxNum = Arrays.stream(arr).max().getAsInt();
        float result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= maxNum) {
                result += arr[i] / (float)maxNum * 100;
            }
        }

        return result / arr.length;
    }
}
