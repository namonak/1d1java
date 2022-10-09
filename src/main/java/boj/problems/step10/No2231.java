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

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        String strNumber = input.readLine();
        int number = Integer.parseInt(strNumber);
        int numberLength = strNumber.length();
        int result = 0;

        for (int i = (number - (numberLength * 9)); i < number; ++i) {
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

        return result;
    }
}
