package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No18258 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(input.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            processCommand(deque, st, sb);
        }
        return sb.toString().trim();
    }

    private static void processCommand(Deque<Integer> deque, StringTokenizer st, StringBuilder sb) {
        String command = st.nextToken();
        switch (command) {
            case "push":
                deque.offer(Integer.parseInt(st.nextToken()));
                return;
            case "pop":
                appendValueOrMinusOne(deque.poll(), sb);
                return;
            case "size":
                sb.append(deque.size()).append("\n");
                return;
            case "empty":
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                return;
            case "front":
                appendValueOrMinusOne(deque.peek(), sb);
                return;
            case "back":
                appendValueOrMinusOne(deque.peekLast(), sb);
                return;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }

    private static void appendValueOrMinusOne(Integer value, StringBuilder sb) {
        sb.append(value == null ? -1 : value).append("\n");
    }
}
