package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2206 {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private static class Node {
        final int row;
        final int col;
        final int broken;
        final int distance;

        Node(int row, int col, int broken, int distance) {
            this.row = row;
            this.col = col;
            this.broken = broken;
            this.distance = distance;
        }
    }

    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(Objects.requireNonNull(input.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = readMap(input, n, m);
        return String.valueOf(findShortestPath(map));
    }

    private static char[][] readMap(BufferedReader input, int n, int m) throws IOException {
        char[][] map = new char[n][m];
        for (int r = 0; r < n; r++) {
            String line = Objects.requireNonNull(input.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        return map;
    }

    private static int findShortestPath(char[][] map) {
        int n = map.length;
        int m = map[0].length;
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.row == n - 1 && current.col == m - 1) {
                return current.distance;
            }

            offerAdjacentNodes(map, visited, queue, current);
        }

        return -1;
    }

    private static void offerAdjacentNodes(
            char[][] map, boolean[][][] visited, Queue<Node> queue, Node current) {
        for (int d = 0; d < 4; d++) {
            int nr = current.row + DR[d];
            int nc = current.col + DC[d];

            if (isInside(map, nr, nc)) {
                offerNextNode(map, visited, queue, current, nr, nc);
            }
        }
    }

    private static void offerNextNode(
            char[][] map,
            boolean[][][] visited,
            Queue<Node> queue,
            Node current,
            int row,
            int col) {
        if (map[row][col] == '0') {
            offerIfUnvisited(visited, queue, row, col, current.broken, current.distance + 1);
            return;
        }

        if (current.broken == 0) {
            offerIfUnvisited(visited, queue, row, col, 1, current.distance + 1);
        }
    }

    private static void offerIfUnvisited(
            boolean[][][] visited, Queue<Node> queue, int row, int col, int broken, int distance) {
        if (visited[row][col][broken]) {
            return;
        }

        visited[row][col][broken] = true;
        queue.offer(new Node(row, col, broken, distance));
    }

    private static boolean isInside(char[][] map, int row, int col) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }
}
