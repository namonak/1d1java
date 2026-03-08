package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No10872 {
    public static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());

        return String.valueOf(factorial(number));
    }

    private static int factorial(int number) {
        if (number <= 1) return 1;

        return number * factorial(number - 1);
    }
}
