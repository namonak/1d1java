package swea.problems;

import java.io.BufferedReader;
import java.util.Objects;

public class SWEA4038 {
    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int testCaseCount = Integer.parseInt(Objects.requireNonNull(br.readLine()).trim());

        for (int t = 1; t <= testCaseCount; t++) {
            String b = Objects.requireNonNull(br.readLine()).trim();
            String s = Objects.requireNonNull(br.readLine()).trim();

            int count = kmpSearch(b, s);
            result.append("#").append(t).append(" ").append(count).append("\n");
        }

        return result.toString().trim();
    }

    private static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] table = makeTable(pattern);
        int count = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == m - 1) {
                    count++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }

        return count;
    }

    private static int[] makeTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table;
    }
}
