package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No34759 {
    public static String solve(BufferedReader input) throws IOException {
        // 사자의 수 N (입력값이 최대 10^18이므로 long 타입 사용)
        long n = Long.parseLong(input.readLine().trim());

        // 얼룩말의 최소 마릿수는 사자 수의 2배
        long answer = n * 2L;

        return String.valueOf(answer);
    }
}
