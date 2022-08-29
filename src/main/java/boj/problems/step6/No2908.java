package boj.problems.step6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int a = reverseNumber(st.nextToken());
        int b = reverseNumber(st.nextToken());

        output.write((a > b ? a : b) + "\n");
    }

    private static int reverseNumber(String str) {
        StringBuffer sb = new StringBuffer(str);

        return Integer.parseInt(sb.reverse().toString());
    }
}
