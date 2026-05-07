package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SWEA7088 {
    public static String solve(BufferedReader input) throws IOException {

        StringBuilder sb = new StringBuilder(1 << 20); // 출력 버퍼 크게 확보
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(input.readLine().trim());

        for (int tc = 1; tc <= testCaseCount; tc++) {

            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // 누적합 배열 (1-indexed)
            int[] p1 = new int[n + 1];
            int[] p2 = new int[n + 1];
            int[] p3 = new int[n + 1];

            // 송아지 품종 입력
            for (int i = 1; i <= n; i++) {
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
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(input.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int c1 = p1[r] - p1[l - 1];
                int c2 = p2[r] - p2[l - 1];
                int c3 = p3[r] - p3[l - 1];

                sb.append(c1).append(' ').append(c2).append(' ').append(c3).append('\n');
            }
        }

        return sb.toString().trim();
    }
}
