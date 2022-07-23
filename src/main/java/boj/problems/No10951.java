package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No10951 {

    public static final int CONVERT_ASCII_TO_INT = 48;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        String str;

        while ((str = input.readLine()) != null) {
            int a = str.charAt(0) - CONVERT_ASCII_TO_INT;
            int b = str.charAt(2) - CONVERT_ASCII_TO_INT;

            output.write((a+b) + "\n");
        }
    }
}
