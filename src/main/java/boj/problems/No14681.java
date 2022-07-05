package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int x = Integer.parseInt(input.readLine());
        int y = Integer.parseInt(input.readLine());

        output.write(getQuadrant(x, y) + "\n");
    }

    private static int getQuadrant(int x, int y) {
        if (x > 0 && y > 0) {
            return 1;
        }

        if (x < 0 && y > 0) {
            return 2;
        }

        if (x < 0 && y < 0) {
            return 3;
        }

        return 4;
    }
}
