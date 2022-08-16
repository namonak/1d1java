package boj.problems.step8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int sqrtNumber = (int)Math.sqrt(number);

        for (int div = 2; div <= sqrtNumber; ++div) {
            while (number % div == 0) {
                number /= div;
                output.write(div + "\n");
            }
        }
        if (number > 1) output.write(number + "\n");
    }
}