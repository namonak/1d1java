package boj.problems.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int n = Integer.parseInt(input.readLine());

        for (int i = 0; i < n; i++) {
            String tmp = input.readLine();
            
            output.write(getResult(tmp) + "\n");
        }
    }

    private static int getResult(String tmp) {
        int result = 0;
        int rate = 0;

        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == 'X') {
                rate = 0;
                continue;
            }
            rate++;
            result += rate;
        }

        return result;
    }
}
