package boj.problems;

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

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int[] arr = makeArray(input);
        HashSet<Integer> resultHash = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            resultHash.add(arr[i] % DIVISOR);
        }

        output.write(resultHash.size() + "\n");
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
