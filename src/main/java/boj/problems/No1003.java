package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class No1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    private static Integer[] fibonacci(int number) {
        int[] fib0 = new int[number + 1];
        int[] fib1 = new int[number + 1];

        fib0[0] = 1;
        fib0[1] = 0;
        fib1[0] = 0;
        fib1[1] = 1;

        for (int i = 2; i <= number; i++) {
            fib0[i] = fib0[i - 1] + fib0[i - 2];
            fib1[i] = fib1[i - 1] + fib1[i - 2];
        }

        return new Integer[] { fib0[number], fib1[number] };
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int testCase = Integer.parseInt(input.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            Integer[] result = fibonacci(Integer.parseInt(st.nextToken()));
            output.write(result[0] + " " + result[1] + "\n");
        }
    }
}
