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
            String command = st.nextToken();
            switch (command) {
                case "push":
                    deque.offer(Integer.parseInt(st.nextToken()));
                    continue;
                case "pop":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(deque.pop()).append("\n");
                    continue;
                case "size":
                    sb.append(deque.size()).append("\n");
                    continue;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    continue;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(deque.peek()).append("\n");
                    continue;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(deque.peekLast()).append("\n");
                    continue;
                default:
                    throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
        return sb.toString().trim();
    }
}
