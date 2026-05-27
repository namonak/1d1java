package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class No10773 {
    public static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        makeStack(input, number, stack);

        return String.valueOf(makeOutput(stack));
    }

    private static int makeOutput(Deque<Integer> stack) {
        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        return sum;
    }

    private static void makeStack(BufferedReader input, int number, Deque<Integer> stack)
            throws IOException {
        for (int i = 0; i < number; i++) {
            int value = Integer.parseInt(input.readLine());
            addValue(stack, value);
        }
    }

    private static void addValue(Deque<Integer> stack, int value) {
        if (value == 0) {
            stack.pop();
            return;
        }
        stack.push(value);
    }
}
