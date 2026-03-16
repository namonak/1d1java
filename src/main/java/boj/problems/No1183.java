package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1183 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine().trim());

        // [예외 차단] N이 비정상적으로 작거나 파일의 끝(EOF)인 경우 방어적 처리
        if (n <= 0) {
            return "0";
        }

        int[] diffs = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            diffs[i] = b - a; // 각 마법사의 지각/일찍 온 시간의 차이 계산
        }

        // N이 홀수일 경우 중앙값이 1개로 특정되므로, T의 개수는 무조건 1개입니다.
        // 불필요한 정렬 연산을 생략하여 성능을 극대화합니다.
        if (n % 2 != 0) {
            return "1";
        }

        // N이 짝수일 경우에만 중앙값의 범위를 구하기 위해 정렬을 수행합니다.
        Arrays.sort(diffs);

        int midRight = n / 2;
        int midLeft = midRight - 1;

        // [오버플로우 회피] diffs 배열의 값은 int 범위 내에 있지만,
        // 두 값의 차이는 최악의 경우 (10^9) - (-10^9) = 2*10^9 로 Integer.MAX_VALUE에 근접합니다.
        // 향후 제한 사항이 확장될 경우를 대비해 long 타입으로 안전하게 승급(Promotion)하여 계산합니다.
        long result = (long) diffs[midRight] - diffs[midLeft] + 1L;

        return String.valueOf(result);
    }
}
