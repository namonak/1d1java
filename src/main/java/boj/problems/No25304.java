package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No25304 {
    public static String solve(BufferedReader input) throws IOException {
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
