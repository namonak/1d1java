package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1920 {
    public static String solve(BufferedReader input) throws IOException {
        int N = Integer.parseInt(input.readLine());
        StringTokenizer tokens = new StringTokenizer(input.readLine());
        ArrayList<Integer> mList = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            mList.add(Integer.parseInt(tokens.nextToken()));
        }

        Collections.sort(mList);

        int M = Integer.parseInt(input.readLine());
        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < M; ++i) {
            if (Collections.binarySearch(mList, Integer.parseInt(tokens.nextToken())) < 0) {
                result.append("0\n");
            } else {
                result.append("1\n");
            }
        }

        return result.toString().trim();
    }
}
