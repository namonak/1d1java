package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SWEA7088 {
    public static String solve(BufferedReader input) throws IOException {

        StringBuilder sb = new StringBuilder(1 << 20); // 출력 버퍼 크게 확보
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            // 누적합 배열 (1-indexed)
            int[] p1 = new int[N + 1];
            int[] p2 = new int[N + 1];
            int[] p3 = new int[N + 1];

            // 송아지 품종 입력
            for (int i = 1; i <= N; i++) {
                int breed = Integer.parseInt(input.readLine().trim());

                // 이전 값 복사 (누적)
                p1[i] = p1[i - 1];
                p2[i] = p2[i - 1];
                p3[i] = p3[i - 1];

                // 해당 품종 증가
                if (breed == 1) {
                    p1[i]++;
                } else if (breed == 2) {
                    p2[i]++;
                } else { // breed == 3
                    p3[i]++;
                }
            }

            sb.append('#').append(tc).append('\n');

            // 질의 처리
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(input.readLine());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                int c1 = p1[R] - p1[L - 1];
                int c2 = p2[R] - p2[L - 1];
                int c3 = p3[R] - p3[L - 1];

                sb.append(c1).append(' ').append(c2).append(' ').append(c3).append('\n');
            }
        }

        return sb.toString().trim();
    }
}
