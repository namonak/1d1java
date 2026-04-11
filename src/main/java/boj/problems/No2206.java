package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
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
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int r = 0; r < n; r++) {
            String line = input.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        boolean[][][] visited = new boolean[n][m][2];
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.row == n - 1 && current.col == m - 1) {
                return String.valueOf(current.distance);
            }

            for (int d = 0; d < 4; d++) {
                int nr = current.row + DR[d];
                int nc = current.col + DC[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (map[nr][nc] == '0') {
                    if (!visited[nr][nc][current.broken]) {
                        visited[nr][nc][current.broken] = true;
                        queue.offer(new Node(nr, nc, current.broken, current.distance + 1));
                    }
                } else { // map[nr][nc] == '1'
                    if (current.broken == 0 && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        queue.offer(new Node(nr, nc, 1, current.distance + 1));
                    }
                }
            }
        }

        return "-1";
    }
}
