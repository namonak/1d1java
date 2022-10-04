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

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int sqrtNumber = (int)Math.sqrt(number);

        return getResult(number, sqrtNumber);
    }

    private static String getResult(int number, int sqrtNumber) {
        StringBuilder sb = new StringBuilder();

        for (int div = 2; div <= sqrtNumber; ++div) {
            number = getNumber(number, sb, div);
        }
        if (number > 1) {
            sb.append(number).append("\n");
        }
        return sb.toString();
    }

    private static int getNumber(int number, StringBuilder sb, int div) {
        while (number % div == 0) {
            number /= div;
            sb.append(div).append("\n");
        }
        return number;
    }
}
