package boj.problems.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write((solve(input)) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int result = 0;
        int newNumber = number;

        do {
            int leftNumber = newNumber / 10;
            int rightNumber = newNumber % 10;
            newNumber = (rightNumber * 10) + ((leftNumber + rightNumber) % 10);
            result++;
        } while(number != newNumber);

        return result;
    }
}