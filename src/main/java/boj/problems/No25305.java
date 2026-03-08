package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No25305 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int testCase = Integer.parseInt(st.nextToken());
        int cutLine = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < testCase; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        return String.valueOf(list.get(cutLine - 1));
    }
}
