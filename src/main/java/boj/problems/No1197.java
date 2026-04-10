package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class No1197 {

    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    private static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            return true;
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

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = br.read();
            }

            int value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = br.read();
            }

            return value * sign;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        FastScanner fs = new FastScanner(input);

        int v = fs.nextInt();
        int e = fs.nextInt();

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges);

        UnionFind uf = new UnionFind(v);
        long totalWeight = 0L;
        int selectedCount = 0;

        for (int i = 0; i < e; i++) {
            Edge edge = edges[i];

            if (uf.union(edge.from, edge.to)) {
                totalWeight += edge.weight;
                selectedCount++;

                if (selectedCount == v - 1) {
                    break;
                }
            }
        }

        return String.valueOf(totalWeight);
    }
}
