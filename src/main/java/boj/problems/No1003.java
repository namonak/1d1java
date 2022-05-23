package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class No1003 {
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    private static int fibonacci(int number) {
        if (0 == number) {
            zero++;
            return 0;
        }
        if (1 == number) {
            one++;
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int testCase = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCase; i++) {
            fibonacci(Integer.parseInt(input.readLine()));
            output.write(zero + " " + one + "\n");
            zero = 0;
            one = 0;
        }
    }
}
