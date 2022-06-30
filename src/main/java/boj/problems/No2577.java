package boj.problems;

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

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());
        int c = Integer.parseInt(input.readLine());

        int[] resultArr = makeResultArray(Integer.toString(a * b * c));

        for (int i = 0; i < resultArr.length; i++) {
            output.write(resultArr[i] + "\n");
        }
    }

    private static int[] makeResultArray(String strNumber) {
        int[] resultArr = new int[MAX_LENGTH];

        for (int i = 0; i < strNumber.length(); i++) {
            resultArr[Integer.parseInt(strNumber.substring(i, i + 1))]++;
        }

        return resultArr;
    }
}
