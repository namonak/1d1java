package boj.problems.step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int score = Integer.parseInt(input.readLine());

        if (score >= 90) {
            output.write("A\n");
        } else if (score >= 80) {
            output.write("B\n");
        } else if (score >= 70) {
            output.write("C\n");
        } else if (score >= 60) {
            output.write("D\n");
        } else {
            output.write("F\n");
        }
    }
}
