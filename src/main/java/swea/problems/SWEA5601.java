package swea.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class SWEA5601 {
    public static String solve(BufferedReader input) throws IOException {
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= testCaseCount; tc++) {
            int n = Integer.parseInt(input.readLine());

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < n; i++) {
                sb.append("1/").append(n);
                if (i < n - 1) {
                    sb.append(" ");
                }
            }

            if (tc < testCaseCount) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
