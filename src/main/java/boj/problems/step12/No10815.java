package boj.problems.step12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        input.close();
        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> cardList = new ArrayList();

        for (int i = 0; i < N; ++i) {
            cardList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(cardList);

        int M = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < M; ++i) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < list.size(); ++i) {
            if (Collections.binarySearch(cardList, list.get(i)) < 0) {
                list.set(i, 0);
            } else {
                list.set(i, 1);
            }
        }

        for (int i = 0; i < list.size(); ++i) {
            output.write(list.get(i) + " ");
        }
    }
}
