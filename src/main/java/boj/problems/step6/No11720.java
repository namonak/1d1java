package boj.problems.step6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(String.valueOf(solve(input)));

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int strLen = Integer.parseInt(input.readLine());
        String inputStr = input.readLine();
        int result = 0;

        for (int i = 0; i < strLen; i++) {
            result += Integer.parseInt(String.valueOf(inputStr.charAt(i)));
        }

        return result;
    }
}
