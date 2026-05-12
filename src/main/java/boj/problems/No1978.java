package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1978 {
    public static String solve(BufferedReader input) throws IOException {
        int result = 0;
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        for (int i = 0; i < n; i++) {
            if (isPrime(Integer.parseInt(st.nextToken()))) {
                result++;
            }
        }

        return String.valueOf(result);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int div = 3; div <= (int) Math.sqrt(number); div += 2) {
            if (number % div == 0) return false;
        }
        return true;
    }
}
