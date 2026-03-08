package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No10430 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        return getResult(A, B, C);
    }

    private static String getResult(int A, int B, int C) {
        return (A + B) % C
                + "\n"
                + ((A % C) + (B % C)) % C
                + "\n"
                + (A * B) % C
                + "\n"
                + ((A % C) * (B % C)) % C;
    }
}
