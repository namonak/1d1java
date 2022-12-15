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

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String tmp = input.readLine();
            
            result.append(getResult(tmp) + "\n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
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
