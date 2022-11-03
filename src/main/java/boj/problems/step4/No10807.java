package boj.problems.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class No10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        output.write(String.valueOf(solve(input)));

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException{
        int number = Integer.parseInt(input.readLine());
        String[] inputString = input.readLine().split(" ");
        int target = Integer.parseInt(input.readLine());

        return getResult(number, inputString, target);
    }

    private static int getResult(int number, String[] inputString, int target) {
        int count = 0;
        for (int i = 0; i < number; i++) {
            count += getCount(inputString, target, i);
        }
        return count;
    }

    private static int getCount(String[] inputString, int target, int i) {
        if (Integer.parseInt(inputString[i]) == target) {
            return 1;
        }
        return 0;
    }
}
