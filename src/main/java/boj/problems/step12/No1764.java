package boj.problems.step12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> list = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N + M; i++) {
            String name = input.readLine();
            if (i < N) list.add(name);
            else {
                if (list.contains(name)) {
                    result.add(name);
                    ++count;
                }
            }
        }

        Collections.sort(result);

        sb.append(count).append("\n");

        for (String s : result) {
            sb.append(s).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
