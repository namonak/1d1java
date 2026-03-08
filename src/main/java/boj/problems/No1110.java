package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No1110 {
    public static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int result = 0;
        int newNumber = number;

        do {
            int leftNumber = newNumber / 10;
            int rightNumber = newNumber % 10;
            newNumber = (rightNumber * 10) + ((leftNumber + rightNumber) % 10);
            result++;
        } while (number != newNumber);

        return String.valueOf(result);
    }
}
