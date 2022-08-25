package boj.problems.step22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No10816 {
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
        HashMap<String, Integer> cards = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            int x = 1;
            String card = st.nextToken();
            if (cards.containsKey(card)) {
                x = cards.get(card) + 1;
            }
            cards.put(card, x);
        }

        int M = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < M; ++i) {
            String card = st.nextToken();
            String result = cards.get(card) == null ? "0" : cards.get(card).toString();

            sb.append(result + " ");
        }

        output.write(sb + "\n");
    }
}
