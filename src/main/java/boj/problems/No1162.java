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

    private static class State {
        int city;
        int paved;
        long cost;

        State(int city, int paved, long cost) {
            this.city = city;
            this.paved = paved;
            this.cost = cost;
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

        List<Edge>[] graph = readGraph(fs, n, m);
        long[][] distance = initializeDistances(n, k);

        return String.valueOf(findShortestPath(graph, distance, n, k));
    }

    private static List<Edge>[] readGraph(FastScanner fs, int cityCount, int roadCount)
            throws IOException {
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[cityCount + 1];
        for (int city = 1; city <= cityCount; city++) {
            graph[city] = new ArrayList<>();
        }

        for (int i = 0; i < roadCount; i++) {
            int from = fs.nextInt();
            int to = fs.nextInt();
            int cost = fs.nextInt();

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }
        return graph;
    }

    private static long[][] initializeDistances(int cityCount, int maxPaved) {
        long[][] distance = new long[cityCount + 1][maxPaved + 1];
        for (int city = 1; city <= cityCount; city++) {
            Arrays.fill(distance[city], INF);
        }
        return distance;
    }

    private static long findShortestPath(
            List<Edge>[] graph, long[][] distance, int destination, int maxPaved) {
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        distance[1][0] = 0L;
        pq.offer(new State(1, 0, 0L));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            if (current.cost != distance[current.city][current.paved]) continue;
            if (current.city == destination) return current.cost;

            relaxAdjacentRoads(graph[current.city], current, distance, maxPaved, pq);
        }

        return findMinimumDistance(distance[destination]);
    }

    private static void relaxAdjacentRoads(
            List<Edge> roads,
            State current,
            long[][] distance,
            int maxPaved,
            PriorityQueue<State> pq) {
        for (Edge road : roads) {
            relaxNormalRoad(road, current, distance, pq);
            relaxPavedRoad(road, current, distance, maxPaved, pq);
        }
    }

    private static void relaxNormalRoad(
            Edge road, State current, long[][] distance, PriorityQueue<State> pq) {
        long nextCost = current.cost + road.weight;
        if (nextCost < distance[road.to][current.paved]) {
            distance[road.to][current.paved] = nextCost;
            pq.offer(new State(road.to, current.paved, nextCost));
        }
    }

    private static void relaxPavedRoad(
            Edge road, State current, long[][] distance, int maxPaved, PriorityQueue<State> pq) {
        if (current.paved < maxPaved && current.cost < distance[road.to][current.paved + 1]) {
            distance[road.to][current.paved + 1] = current.cost;
            pq.offer(new State(road.to, current.paved + 1, current.cost));
        }
    }

    private static long findMinimumDistance(long[] distances) {
        long answer = INF;
        for (long distance : distances) {
            answer = Math.min(answer, distance);
        }
        return answer;
    }
}
