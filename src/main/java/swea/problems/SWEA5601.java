package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class SWEA5601 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(input.readLine());

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < N; i++) {
                sb.append("1/").append(N);
                if (i < N - 1) {
                    sb.append(" ");
                }
            }

            if (tc < T) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
