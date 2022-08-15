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

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int totalPrice = Integer.parseInt(input.readLine());
        int inputNum = Integer.parseInt(input.readLine());
        int sum = 0;

        for (int i = 0; i < inputNum; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int price = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            sum += price * number;
        }

        if (sum == totalPrice) output.write("Yes" +"\n");
        else output.write("No" +"\n");
    }
}