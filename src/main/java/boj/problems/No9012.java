package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class No9012 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(input.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < number; i++) {
            String[] line = input.readLine().split("");
            getResult(sb, stack, line);
        }
        return sb.toString();
    }

    private static void getResult(StringBuilder sb, Stack<String> stack, String[] line) {
        stack.clear();
        try {
            isYesOrNo(sb, stack, line);
        } catch (Exception e) {
            sb.append("NO" + "\n");
        }
    }

    private static void isYesOrNo(StringBuilder sb, Stack<String> stack, String[] line) {
        for (String ps : line) {
            setStack(stack, ps);
        }
        if (stack.isEmpty()) {
            sb.append("YES" + "\n");
            return;
        }
        sb.append("NO" + "\n");
    }

    private static void setStack(Stack<String> stack, String ps) {
        if (ps.equals("(")) {
            stack.push(ps);
            return;
        }
        if (ps.equals(")")) {
            stack.pop();
        }
    }
}
