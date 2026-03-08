package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class No2581 {
    public static String solve(BufferedReader input) throws IOException {
        int M = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        List<Integer> primeList = new ArrayList<>();
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) primeList.add(i);
        }

        for (Object o : primeList) {
            sum += (int) o;
        }

        if (primeList.isEmpty()) {
            return String.valueOf(-1);
        }
        return String.format("%d\n%d", sum, primeList.get(0));
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
