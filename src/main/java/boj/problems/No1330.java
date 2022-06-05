package boj.problems;

import java.io.*;
import java.util.StringTokenizer;

public class No1330 {
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

        if (a < b) {
            output.write("<\n");
            return;
        }

        if (a > b) {
            output.write(">\n");
            return;
        }

        output.write("==\n");
        return;
    }
}
