package boj.problems.step10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2231 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        input.close();
        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int result = 0;

        for (int i = 0; i < number; ++i) {
            int tmp = i;
            int sum = 0;

            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (i + sum == number) {
                result = i;
                break;
            }
        }

        output.write(result + "\n");
    }
}