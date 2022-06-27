package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        output.write(getPrizeMoney(a, b, c) + "\n");
    }

    private static int getPrizeMoney(int a, int b, int c) {
       if (a == b && b == c) {
           return 10000 + (a * 1000);
       }

       if (a == b || a == c) {
           return 1000 + (a * 100);
       }

       if (b == c) {
           return 1000 + (b * 100);
       }

       return getMaximum(a, b, c) * 100;
    }

    private static int getMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }
}
