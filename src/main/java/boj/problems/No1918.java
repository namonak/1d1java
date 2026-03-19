package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class No1918 {

    public static String solve(BufferedReader input) throws IOException {
        String expression = input.readLine();
        if (expression == null || expression.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder(expression.length());
        Deque<Character> operators = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (isOperand(ch)) {
                result.append(ch);
                continue;
            }

            if (ch == '(') {
                operators.push(ch);
                continue;
            }

            if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    result.append(operators.pop());
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                }
                continue;
            }

            while (!operators.isEmpty()
                    && operators.peek() != '('
                    && precedence(operators.peek()) >= precedence(ch)) {
                result.append(operators.pop());
            }
            operators.push(ch);
        }

        while (!operators.isEmpty()) {
            result.append(operators.pop());
        }

        return result.toString();
    }

    private static boolean isOperand(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }
}
