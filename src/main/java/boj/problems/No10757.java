package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class No10757 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        return a.add(b).toString();
    }
}
