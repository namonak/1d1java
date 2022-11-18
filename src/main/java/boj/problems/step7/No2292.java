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

        output.write(String.valueOf(solve(input)));

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int count = 1;
        int range = 2;
        if (number == 1) {
            return 1;
        }
        while (range <= number) {
            range = range + (count * 6);
            count++;
        }
        return count;
    }
}
