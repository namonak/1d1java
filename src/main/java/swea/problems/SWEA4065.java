package swea.problems;

import java.io.BufferedReader;

public class SWEA4065 {
    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            String strA = br.readLine().trim();
            String strB = br.readLine().trim();

            int tmp = lcsLen(strA, strB);

            result.append("#").append(t).append(" ").append(tmp).append("\n");
        }

        return result.toString().trim();
    }

    private static int lcsLen(String strA, String strB) {
        int lenStrA = strA.length();
        int lenStrB = strB.length();

        int[][] dp = new int[lenStrA + 1][lenStrB + 1];

        for (int i = 1; i <= lenStrA; i++) {
            for (int j = 1; j <= lenStrB; j++) {
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[lenStrA][lenStrB];
    }
}
