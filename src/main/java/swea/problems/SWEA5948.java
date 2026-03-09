package swea.problems;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA5948 {
    private static final int INPUT_SIZE = 7;
    private static final int SELECT_COUNT = 3;

    private static int[] numbers;
    private static Set<Integer> distinctSums;

    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= testCaseCount; t++) {
            numbers = new int[INPUT_SIZE];
            distinctSums = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < INPUT_SIZE; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            searchCombinations(0, 0, 0);

            List<Integer> sortedList = new ArrayList<>(distinctSums);
            sortedList.sort(Collections.reverseOrder());

            result.append("#").append(t).append(" ").append(sortedList.get(4)).append("\n");
        }

        return result.toString().trim();
    }

    private static void searchCombinations(int startIdx, int currentSum, int depth) {
        if (depth == SELECT_COUNT) {
            distinctSums.add(currentSum);
            return;
        }

        for (int i = startIdx; i < INPUT_SIZE; i++) {
            searchCombinations(i + 1, currentSum + numbers[i], depth + 1);
        }
    }
}
