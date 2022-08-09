package boj.problems.step8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int result = 0;
        // N은 사용하지 않음
        input.readLine();
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        while (st.hasMoreTokens()) {
            if (isPrime(Integer.parseInt(st.nextToken()))) {
                result++;
            }
        }

        output.write(result + "\n");
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
