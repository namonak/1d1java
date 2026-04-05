package boj.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class No21212 {
    public static String solve(BufferedReader input) throws Exception {
        // 첫 번째 줄에서 재료의 개수 N을 읽어옵니다.
        int n = Integer.parseInt(input.readLine().trim());

        // 만들 수 있는 최대 케이크 수를 저장할 변수입니다.
        // 최솟값을 찾아야 하므로 초기값은 가질 수 있는 가장 큰 정수로 설정합니다.
        int maxCakes = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine(), " ");
            int required = Integer.parseInt(st.nextToken()); // 케이크 1개당 필요한 양
            int available = Integer.parseInt(st.nextToken()); // 주방에 있는 양

            // 현재 재료로 만들 수 있는 케이크의 수
            int possibleCakes = available / required;

            // 기존에 계산된 최대 케이크 수와 현재 재료로 만들 수 있는 케이크 수 중 더 작은 값을 선택합니다.
            maxCakes = Math.min(maxCakes, possibleCakes);
        }

        // 결과를 문자열로 변환하여 반환합니다.
        return String.valueOf(maxCakes);
    }
}
