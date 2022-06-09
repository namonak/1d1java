package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class No2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());

        List<Integer> list = new ArrayList<>();

        while (b != 0) {
            list.add(a * (b % 10));
            b /= 10;
        }

        output.write(list.get(0) + "\n");
        output.write(list.get(1) + "\n");
        output.write(list.get(2) + "\n");
        output.write(list.get(0) + list.get(1) * 10 + list.get(2) * 100 +"\n");
    }
}
