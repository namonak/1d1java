package boj.problems.step19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(String.valueOf(solve(input)));

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        Stack<Integer> stack = new Stack<>();
        makeStack(input, number, stack);

        return makeOutput(stack);
    }

    private static int makeOutput(Stack<Integer> stack) {
        int sum = 0;
        for(int num : stack) {
            sum += num;
        }
        return sum;
    }

    private static void makeStack(BufferedReader input, int number, Stack<Integer> stack) throws IOException {
        for (int i = 0; i < number; i++) {
            int value = Integer.parseInt(input.readLine());
            addValue(stack, value);
        }
    }

    private static void addValue(Stack<Integer> stack, int value) {
        if (value == 0) {
            stack.pop();
            return;
        }
        stack.push(value);
    }
}
