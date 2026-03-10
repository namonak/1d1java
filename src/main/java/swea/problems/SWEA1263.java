package swea.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA1263 {

    private static final int INF = 1_000_000; // 안전한 최대값

    public static String solve(BufferedReader br) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder(8 * T);

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[][] dist = new int[N][N];

            // --- 초기화 ---
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = (val == 1) ? 1 : INF;
                    }
                }
            }

            // --- Floyd–Warshall ---
            for (int k = 0; k < N; k++) {
                int[] distK = dist[k]; // 캐시 최적화
                for (int i = 0; i < N; i++) {
                    int[] distI = dist[i];
                    int viaIK = distI[k];

                    if (viaIK == INF) continue; // pruning

                    for (int j = 0; j < N; j++) {
                        int alt = viaIK + distK[j];
                        if (alt < distI[j]) {
                            distI[j] = alt;
                        }
                    }
                }
            }

            // --- 정답 계산: 각 행의 합 중 최솟값 ---
            int answer = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                int sum = 0;
                int[] row = dist[i];

                for (int j = 0; j < N; j++) {
                    sum += row[j];
                }

                if (sum < answer) answer = sum;
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        return sb.toString().trim();
    }
}
