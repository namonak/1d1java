package boj.problems.step1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());
        return getResult(a, b);
    }

    private static String getResult(int a, int b) {
        StringBuilder sb = new StringBuilder();

        sb.append(a * (b % 10));
        sb.append('\n');
        sb.append(a * ((b % 100) / 10));
        sb.append('\n');
        sb.append(a * (b / 100));
        sb.append('\n');
        sb.append(a * b);
        return sb.toString();
    }
}
