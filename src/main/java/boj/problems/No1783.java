package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1783 {
    public static String solve(BufferedReader input) throws IOException {
        String line = input.readLine();
        if (line == null) return "0";

        StringTokenizer st = new StringTokenizer(line);
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long result;

        if (n == 1) {
            // 세로가 1이면 이동 불가
            result = 1;
        } else if (n == 2) {
            // 세로가 2이면 2번, 3번 규칙만 사용 가능 (최대 4칸)
            // 가로 이동이 2씩 발생하므로 (m+1)/2 계산
            result = Math.min(4, (m + 1) / 2);
        } else {
            // 세로가 3 이상인 경우
            if (m < 7) {
                // 가로가 7 미만이면 4가지 규칙을 다 쓸 수 없어 최대 4칸
                result = Math.min(4, m);
            } else {
                // 가로가 7 이상이면 모든 규칙 사용 후 오른쪽 1칸씩 이동
                // 4가지 규칙 사용 시 가로 6칸 소모하여 5칸 방문 -> 그 뒤론 m-6칸 추가 방문
                // 식: 5 + (m - 7) = m - 2
                result = m - 2;
            }
        }

        return String.valueOf(result);
    }
}
