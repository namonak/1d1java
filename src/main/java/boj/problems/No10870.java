package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int n = Integer.parseInt(input.readLine());

        output.write(getNthFibonacci(n) + "\n");
    }

    private static int getNthFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
