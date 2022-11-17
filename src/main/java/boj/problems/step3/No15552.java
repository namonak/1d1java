package boj.problems.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class No15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException{
        int testCase = Integer.parseInt(input.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            result.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }
}
