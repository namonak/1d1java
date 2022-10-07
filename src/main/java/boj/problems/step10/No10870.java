package boj.problems.step10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());

        return getNthFibonacci(n);
    }

    private static int getNthFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
