package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class No15681 {
    public static String solve(BufferedReader input) throws IOException {
        FastReader reader = new FastReader(input);

        int n = reader.nextInt();
        int root = reader.nextInt();
        int queryCount = reader.nextInt();

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int node = 1; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] subtreeSize = calculateSubtreeSizes(graph, root, n);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < queryCount; i++) {
            int queryNode = reader.nextInt();
            answer.append(subtreeSize[queryNode]).append('\n');
        }

        return answer.toString();
    }

    private static int[] calculateSubtreeSizes(List<Integer>[] graph, int root, int n) {
        int[] subtreeSize = new int[n + 1];
        Deque<State> stack = new ArrayDeque<>();

        stack.push(new State(root, 0, false));

        while (!stack.isEmpty()) {
            State current = stack.pop();
            processState(graph, subtreeSize, stack, current);
        }

        return subtreeSize;
    }

    private static void processState(
            List<Integer>[] graph, int[] subtreeSize, Deque<State> stack, State current) {
        if (current.processed) {
            subtreeSize[current.node] = sumSubtreeSize(graph, subtreeSize, current);
            return;
        }

        stack.push(new State(current.node, current.parent, true));
        pushChildren(graph, stack, current);
    }

    private static void pushChildren(List<Integer>[] graph, Deque<State> stack, State current) {
        for (int next : graph[current.node]) {
            if (next != current.parent) {
                stack.push(new State(next, current.node, false));
            }
        }
    }

    private static int sumSubtreeSize(List<Integer>[] graph, int[] subtreeSize, State current) {
        int size = 1;
        for (int child : graph[current.node]) {
            if (child != current.parent) {
                size += subtreeSize[child];
            }
        }
        return size;
    }

    private static class State {
        private final int node;
        private final int parent;
        private final boolean processed;

        private State(int node, int parent, boolean processed) {
            this.node = node;
            this.parent = parent;
            this.processed = processed;
        }
    }

    private static class FastReader {
        private final BufferedReader input;
        private StringTokenizer tokenizer;

        private FastReader(BufferedReader input) {
            this.input = input;
        }

        private int nextInt() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = input.readLine();
                if (line == null) {
                    throw new IOException("Unexpected end of input");
                }
                tokenizer = new StringTokenizer(line);
            }
            return Integer.parseInt(tokenizer.nextToken());
        }
    }
}
