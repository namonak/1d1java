package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No2577 {
    public static final int MAX_LENGTH = 10;

    public static String solve(BufferedReader input) throws IOException {
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());
        int c = Integer.parseInt(input.readLine());

        int[] resultArr = makeResultArray(Integer.toString(a * b * c));

        return makeOutput(resultArr).trim();
    }

    private static String makeOutput(int[] resultArr) {
        StringBuilder sb = new StringBuilder();
        for (int j : resultArr) {
            sb.append(j).append("\n");
        }
        return sb.toString();
    }

    private static int[] makeResultArray(String strNumber) {
        int[] resultArr = new int[MAX_LENGTH];

        for (int i = 0; i < strNumber.length(); i++) {
            resultArr[Integer.parseInt(strNumber.substring(i, i + 1))]++;
        }

        return resultArr;
    }
}
