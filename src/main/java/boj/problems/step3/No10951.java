package boj.problems.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10951 {
    public static final int CONVERT_ASCII_TO_INT = 48;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringBuilder tokens = new StringBuilder();
        String str;

        while ((str = input.readLine()) != null) {
            int a = str.charAt(0) - CONVERT_ASCII_TO_INT;
            int b = str.charAt(2) - CONVERT_ASCII_TO_INT;

            tokens.append(a + b).append("\n");
        }
        tokens.setLength(tokens.length() - 1);
        return tokens.toString();
    }
}
