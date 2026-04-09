package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1167 {

    private static List<Edge>[] graph;

    private static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Result {
        int vertex;
        int distance;

        Result(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        int v = Integer.parseInt(input.readLine());

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());
                graph[from].add(new Edge(to, weight));
            }
        }

        Result first = findFarthest(1, v);
        Result second = findFarthest(first.vertex, v);

        return String.valueOf(second.distance);
    }

    private static Result findFarthest(int start, int v) {
        boolean[] visited = new boolean[v + 1];
        int[] distance = new int[v + 1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        visited[start] = true;
        stack.push(start);

        int farthestVertex = start;
        int maxDistance = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (distance[current] > maxDistance) {
                maxDistance = distance[current];
                farthestVertex = current;
            }

            for (Edge next : graph[current]) {
                if (visited[next.to]) {
                    continue;
                }

                visited[next.to] = true;
                distance[next.to] = distance[current] + next.weight;
                stack.push(next.to);
            }
        }

        return new Result(farthestVertex, maxDistance);
    }
}
