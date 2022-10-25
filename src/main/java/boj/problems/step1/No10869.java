package boj.problems.step1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        return getResult(a, b);
    }

    private static String getResult(int a, int b) {
        String result = "";

        result += a + b + "\n";
        result += a - b + "\n";
        result += a * b + "\n";
        result += a / b + "\n";
        result += a % b;

        return result;
    }
}
