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

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (n < number) {
                sb.append(n + " ");
            }
        }

        output.write(String.valueOf(sb));
    }
}
