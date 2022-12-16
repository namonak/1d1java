package boj.problems.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No3052 {
    public static final int DIVISOR = 42;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(String.valueOf(solve(input)));

        input.close();
        output.flush();
        output.close();
    }

    static int solve(BufferedReader input) throws IOException {
        int[] arr = makeArray(input);
        HashSet<Integer> resultHash = new HashSet<>();

        for (int j : arr) {
            resultHash.add(j % DIVISOR);
        }

        return resultHash.size();
    }

    private static int[] makeArray(BufferedReader input) throws IOException{
        List<Integer> List = new ArrayList<>();
        String tmp;

        while ((tmp = input.readLine()) != null) {
            List.add(Integer.parseInt(tmp));
        }

        return List.stream().mapToInt(i -> i).toArray();
    }
}
