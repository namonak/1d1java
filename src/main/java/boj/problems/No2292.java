package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2292 {
    public static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        int count = 1;
        int range = 2;
        if (number == 1) {
            return String.valueOf(count);
        }
        while (range <= number) {
            range = range + (count * 6);
            count++;
        }
        return String.valueOf(count);
    }
}
