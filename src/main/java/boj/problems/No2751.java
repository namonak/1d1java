package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class No2751 {
    static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        ArrayList<Integer> sortedList = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < number; i++) {
            sortedList.add(Integer.parseInt(input.readLine()));
        }

        Collections.sort(sortedList);

        for (Integer integer : sortedList) {
            result.append(integer).append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
