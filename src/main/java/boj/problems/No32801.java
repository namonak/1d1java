package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No32801 {
    public static String solve(BufferedReader input) throws IOException {
        String line = input.readLine();
        if (line == null) return "";

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 1. 최소공배수(LCM) 구하기
        long lcmValue = getLCM(a, b);

        // 2. 각 배수의 개수 계산 (n / k)
        int countA = n / a;
        int countB = n / b;

        // n보다 lcmValue가 클 수 있으므로 long 처리 후 비교
        int countBoth = 0;
        if (lcmValue <= n) {
            countBoth = (int) (n / lcmValue);
        }

        // 3. 겹치는 부분 제외하여 결과 도출
        int fizz = countA - countBoth;
        int buzz = countB - countBoth;
        int fizzBuzz = countBoth;

        return fizz + " " + buzz + " " + fizzBuzz;
    }

    /** 최대공약수(GCD)를 구하는 메소드 (유클리드 호제법) */
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /** 최소공배수(LCM)를 구하는 메소드 */
    private static long getLCM(int a, int b) {
        // (a * b) / gcd 과정에서 overflow 방지를 위해 long 사용
        return ((long) a * b) / getGCD(a, b);
    }
}
