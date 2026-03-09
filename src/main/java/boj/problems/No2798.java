package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2798 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int givenNumber = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return String.valueOf(getResult(arr, n, givenNumber));
    }

    private static int getResult(int[] arr, int n, int givenNumber) {
        int best = 0;

        for (int i = 0; i < n - 2; i++) {
            if (arr[i] > givenNumber) {
                continue;
            }
            best = findBestWithFirstCard(arr, n, givenNumber, i, best);
            if (best == givenNumber) {
                return best;
            }
        }
        return best;
    }

    private static int findBestWithFirstCard(
            int[] arr, int n, int givenNumber, int firstIndex, int currentBest) {
        int best = currentBest;

        for (int j = firstIndex + 1; j < n - 1; j++) {
            int firstTwoSum = arr[firstIndex] + arr[j];
            if (firstTwoSum > givenNumber) {
                continue;
            }

            best = findBestWithThirdCard(arr, n, givenNumber, j, firstTwoSum, best);
            if (best == givenNumber) {
                return best;
            }
        }

        return best;
    }

    private static int findBestWithThirdCard(
            int[] arr, int n, int givenNumber, int secondIndex, int firstTwoSum, int currentBest) {
        int best = currentBest;

        for (int k = secondIndex + 1; k < n; k++) {
            int sum = firstTwoSum + arr[k];

            if (sum == givenNumber) {
                return sum;
            }

            if (sum > best && sum < givenNumber) {
                best = sum;
            }
        }

        return best;
    }
}
