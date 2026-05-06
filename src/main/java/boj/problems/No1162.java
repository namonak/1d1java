package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No1162 {

    private static final long INF = Long.MAX_VALUE / 4;

    private static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class State implements Comparable<State> {
        int city;
        int paved;
        long cost;

        State(int city, int paved, long cost) {
            this.city = city;
            this.paved = paved;
            this.cost = cost;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    private static class FastScanner {
        private final BufferedReader br;

        FastScanner(BufferedReader br) {
            this.br = br;
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = br.read();
            } while (c <= ' ');

            int value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = br.read();
            }

            return value;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        FastScanner fs = new FastScanner(input);

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int cost = fs.nextInt();

            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        long[][] distance = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], INF);
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        distance[1][0] = 0L;
        pq.offer(new State(1, 0, 0L));

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.cost != distance[current.city][current.paved]) {
                continue;
            }

            if (current.city == n) {
                return String.valueOf(current.cost);
            }

            for (Edge next : graph[current.city]) {
                long nextCost = current.cost + next.weight;
                if (nextCost < distance[next.to][current.paved]) {
                    distance[next.to][current.paved] = nextCost;
                    pq.offer(new State(next.to, current.paved, nextCost));
                }

                if (current.paved < k && current.cost < distance[next.to][current.paved + 1]) {
                    distance[next.to][current.paved + 1] = current.cost;
                    pq.offer(new State(next.to, current.paved + 1, current.cost));
                }
            }
        }

        long answer = INF;
        for (int paved = 0; paved <= k; paved++) {
            answer = Math.min(answer, distance[n][paved]);
        }
        return String.valueOf(answer);
    }
}
