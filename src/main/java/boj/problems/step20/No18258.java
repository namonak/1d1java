package boj.problems.step20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(input.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                deque.offer(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (command.equals("pop")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(deque.pop()).append("\n");
                continue;
            }
            if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
                continue;
            }
            if (command.equals("empty")) {
                sb.append(deque.size() == 0 ? 1 : 0).append("\n");
                continue;
            }
            if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(deque.peek()).append("\n");
                continue;
            }
            if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(deque.peekLast()).append("\n");
            }
        }
        return sb.toString();
    }
}
