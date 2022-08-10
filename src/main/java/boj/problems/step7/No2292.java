package boj.problems.step7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int count = 1;
        int range = 2;

        if (number == 1) {
            output.write(1 + "\n");
            return;
        }
        while (range <= number) {
            range = range + (count * 6);
            count++;
        }
        output.write(count + "\n");
    }
}