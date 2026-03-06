package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No10815 {
    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> cardList = new ArrayList();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            cardList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(cardList);

        int M = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < M; ++i) {
            if (Collections.binarySearch(cardList, Integer.parseInt(st.nextToken())) < 0) {
                sb.append("0 ");
            } else {
                sb.append("1 ");
            }
        }

        output.write(sb.toString().trim());
    }
}
