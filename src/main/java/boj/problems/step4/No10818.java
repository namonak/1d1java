package boj.problems.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int testCase = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] intArray = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        return Arrays.stream(intArray).min().getAsInt() + " " +Arrays.stream(intArray).max().getAsInt();
    }
}
