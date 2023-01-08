package boj.problems.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input);

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringBuilder result = new StringBuilder();
        int totalPrice = Integer.parseInt(input.readLine());
        int inputNum = Integer.parseInt(input.readLine());
        int sum = 0;

        for (int i = 0; i < inputNum; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int price = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            sum += price * number;
        }

        if (sum == totalPrice) {
            return result.append("Yes").toString();
        }
        return result.append("No").toString();
    }
}