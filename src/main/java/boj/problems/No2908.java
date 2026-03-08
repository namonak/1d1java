package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2908 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int a = reverseNumber(st.nextToken());
        int b = reverseNumber(st.nextToken());

        return String.valueOf(Math.max(a, b));
    }

    private static int reverseNumber(String str) {
        StringBuilder sb = new StringBuilder(str);

        return Integer.parseInt(sb.reverse().toString());
    }
}
