package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2231 {
    public static String solve(BufferedReader input) throws IOException {
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

        return String.valueOf(result);
    }
}
