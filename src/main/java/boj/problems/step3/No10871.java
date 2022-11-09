package boj.problems.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(st.nextToken());
            makeResult(sb, number, n);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static void makeResult(StringBuilder sb, int number, int n) {
        if (n < number) {
            sb.append(n).append(" ");
        }
    }
}
