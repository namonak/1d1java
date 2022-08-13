package boj.problems.step11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class No2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int n = Integer.parseInt(input.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input.readLine()));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            output.write(list.get(i) + "\n");
        }
    }
}
