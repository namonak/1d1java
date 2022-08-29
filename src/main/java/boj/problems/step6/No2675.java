package boj.problems.step6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int testCase = Integer.parseInt(input.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());

            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            output.write(getResult(n, str) + "\n");
        }
    }

    private static String getResult(int n, String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < n; j++) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
