package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class No2517 {
    public static String solve(BufferedReader input) throws IOException {

        int n = Integer.parseInt(input.readLine());

        int[] skill = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            skill[i] = Integer.parseInt(input.readLine());
            sorted[i] = skill[i];
        }

        // 1️. 좌표 압축
        Arrays.sort(sorted);

        int[] compressed = new int[n];
        for (int i = 0; i < n; i++) {
            // 모든 값이 다르므로 binarySearch 사용 가능
            compressed[i] = Arrays.binarySearch(sorted, skill[i]) + 1;
        }

        // 2. Fenwick Tree
        int[] tree = new int[n + 1];

        StringBuilder sb = new StringBuilder(n * 3);

        for (int i = 0; i < n; i++) {

            int rank = compressed[i];

            // 현재까지 삽입된 수 = i
            int smallerOrEqual = query(tree, rank);
            int greater = i - smallerOrEqual;

            sb.append(greater + 1).append('\n');

            update(tree, rank, 1, n);
        }

        return sb.toString().trim();
    }

    // Fenwick update
    private static void update(int[] tree, int index, int value, int size) {
        while (index <= size) {
            tree[index] += value;
            index += index & -index;
        }
    }

    // Fenwick prefix sum
    private static int query(int[] tree, int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}
