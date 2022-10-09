package boj.problems.step9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());

        return factorial(number);
    }

    private static int factorial(int number) {
        if (number <= 1) return 1;

        return number * factorial(number - 1);
    }
}
