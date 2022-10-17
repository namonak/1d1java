package boj.problems.step1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2577 {
    public static final int MAX_LENGTH = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());
        int c = Integer.parseInt(input.readLine());

        int[] resultArr = makeResultArray(Integer.toString(a * b * c));

        return makeOutput(resultArr);
    }

    private static String makeOutput(int[] resultArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultArr.length; i++) {
            sb.append(resultArr[i] + "\n");
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
