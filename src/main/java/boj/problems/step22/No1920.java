package boj.problems.step22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1920 {
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
        ArrayList<Integer> mList= new ArrayList();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            mList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(mList);

        int M = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < M; ++i) {
            if (Collections.binarySearch(mList, Integer.parseInt(st.nextToken())) < 0) {
                sb.append("0\n");
            } else {
                sb.append("1\n");
            }
        }

        output.write(sb.toString());
    }
}
