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

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

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
