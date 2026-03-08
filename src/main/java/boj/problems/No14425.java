package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No14425 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> strSet = new HashSet<>();
        int resultCnt = 0;

        for (int i = 0; i < N + M; ++i) {
            if (i < N) {
                strSet.add(input.readLine());
            } else {
                if (strSet.contains(input.readLine())) resultCnt++;
            }
        }

        return String.valueOf(resultCnt);
    }
}
