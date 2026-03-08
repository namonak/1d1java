package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No3052 {
    public static final int DIVISOR = 42;

    public static String solve(BufferedReader input) throws IOException {
        int[] arr = makeArray(input);
        HashSet<Integer> resultHash = new HashSet<>();

        for (int j : arr) {
            resultHash.add(j % DIVISOR);
        }

        return String.valueOf(resultHash.size());
    }

    private static int[] makeArray(BufferedReader input) throws IOException {
        List<Integer> List = new ArrayList<>();
        String tmp;

        while ((tmp = input.readLine()) != null) {
            List.add(Integer.parseInt(tmp));
        }

        return List.stream().mapToInt(i -> i).toArray();
    }
}
