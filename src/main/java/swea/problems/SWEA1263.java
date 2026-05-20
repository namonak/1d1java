package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class SWEA1263 {

    private static final int INF = 1_000_000; // 안전한 최대값

    public static String solve(BufferedReader br) throws IOException {
        int testCaseCount = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());
        StringBuilder sb = new StringBuilder(8 * testCaseCount);

        for (int tc = 1; tc <= testCaseCount; tc++) {
            int answer = solveCase(br);
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        return sb.toString().trim();
    }

    private static int solveCase(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(Objects.requireNonNull(br.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int[][] dist = readDistances(st, n);

        floydWarshall(dist);
        return findMinimumPathSum(dist);
    }

    private static int[][] readDistances(StringTokenizer st, int n) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                dist[i][j] = initialDistance(i, j, value);
            }
        }

        return dist;
    }

    private static int initialDistance(int from, int to, int value) {
        if (from == to) {
            return 0;
        }
        return value == 1 ? 1 : INF;
    }

    private static void floydWarshall(int[][] dist) {
        for (int k = 0; k < dist.length; k++) {
            int[] distK = dist[k];
            for (int i = 0; i < dist.length; i++) {
                relaxRow(dist[i], distK, dist[i][k]);
            }
        }
    }

    private static void relaxRow(int[] distI, int[] distK, int viaIK) {
        if (viaIK == INF) return;

        for (int j = 0; j < distI.length; j++) {
            int alt = viaIK + distK[j];
            if (alt < distI[j]) {
                distI[j] = alt;
            }
        }
    }

    private static int findMinimumPathSum(int[][] dist) {
        int answer = Integer.MAX_VALUE;

        for (int[] row : dist) {
            answer = Math.min(answer, sum(row));
        }

        return answer;
    }

    private static int sum(int[] values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }
}
