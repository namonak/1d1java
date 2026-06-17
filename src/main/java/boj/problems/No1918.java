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

        return toPostfix(expression);
    }

    private static String toPostfix(String expression) {
        StringBuilder result = new StringBuilder(expression.length());
        Deque<Character> operators = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            appendToken(expression.charAt(i), result, operators);
        }

        appendRemainingOperators(result, operators);

        return result.toString();
    }

    private static void appendToken(char ch, StringBuilder result, Deque<Character> operators) {
        if (isOperand(ch)) {
            result.append(ch);
            return;
        }

        if (ch == '(') {
            operators.push(ch);
            return;
        }

        if (ch == ')') {
            appendClosingParenthesis(result, operators);
            return;
        }

        appendOperator(ch, result, operators);
    }

    private static void appendClosingParenthesis(StringBuilder result, Deque<Character> operators) {
        while (!operators.isEmpty() && operators.peek() != '(') {
            result.append(operators.pop());
        }

        if (!operators.isEmpty() && operators.peek() == '(') {
            operators.pop();
        }
    }

    private static void appendOperator(
            char operator, StringBuilder result, Deque<Character> operators) {
        while (hasPrecedenceOverNext(operators, operator)) {
            result.append(operators.pop());
        }

        operators.push(operator);
    }

    private static boolean hasPrecedenceOverNext(Deque<Character> operators, char operator) {
        return !operators.isEmpty()
                && operators.peek() != '('
                && precedence(operators.peek()) >= precedence(operator);
    }

    private static void appendRemainingOperators(StringBuilder result, Deque<Character> operators) {
        while (!operators.isEmpty()) {
            result.append(operators.pop());
        }
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
