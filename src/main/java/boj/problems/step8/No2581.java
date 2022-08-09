package boj.problems.step8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int M = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        ArrayList primeList = new ArrayList();
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if(isPrime(i)) primeList.add(i);
        }

        for (Object o : primeList) {
            sum += (int) o;
        }

        if (primeList.size() == 0) output.write(-1 + "\n");
        else output.write(sum + System.lineSeparator() + primeList.get(0));
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int div = 3; div <= (int)Math.sqrt(number); div += 2) {
            if (number % div == 0) return false;
        }
        return true;
    }
}
