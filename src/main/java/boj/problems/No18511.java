package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No18511 {
    private static int maxResult;
    private static int targetN;
    private static int[] elementsK;

    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        targetN = Integer.parseInt(st.nextToken());
        int kCount = Integer.parseInt(st.nextToken());

        elementsK = new int[kCount];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < kCount; i++) {
            elementsK[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(elementsK);

        maxResult = 0;
        findMaxNumber(0);

        return String.valueOf(maxResult);
    }

    private static void findMaxNumber(long current) {
        // 현재 숫자가 N보다 크면 더 이상 탐색하지 않음
        if (current > targetN) {
            return;
        }

        // 현재 숫자가 N 이하인 경우 maxResult 갱신
        if (current > maxResult) {
            maxResult = (int) current;
        }

        // 자릿수가 9자리를 넘어가면 중단 (N의 최대값이 10^8이므로 10^9부터는 불필요)
        if (current >= 100_000_000) {
            return;
        }

        // K의 모든 원소를 순회하며 뒤에 붙여봄
        for (int j : elementsK) {
            // 자릿수 올리기: 기존 숫자 * 10 + 새로운 원소
            findMaxNumber(current * 10 + j);
        }
    }
}
