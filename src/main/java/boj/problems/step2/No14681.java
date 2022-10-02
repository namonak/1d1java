package boj.problems.step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int x = Integer.parseInt(input.readLine());
        int y = Integer.parseInt(input.readLine());

        return getQuadrant(x, y);
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
