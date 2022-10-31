package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(String.valueOf(solve(input)));

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        String[] inputString = input.readLine().split(" ");
        int x = Integer.parseInt(inputString[0]);
        int y = Integer.parseInt(inputString[1]);
        int w = Integer.parseInt(inputString[2]);
        int h = Integer.parseInt(inputString[3]);

        return getResult(x, y, w, h);
    }

    private static int getResult(int x, int y, int w, int h) {
        int min = Math.min(x, y);
        min = Math.min(min, w - x);
        min = Math.min(min, h - y);

        return min;
    }
}
