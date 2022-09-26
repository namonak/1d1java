package boj.problems.step1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class No18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int year = Integer.parseInt(input.readLine());

        return year - 543;
    }
}
