package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2804 {
    public static String solve(BufferedReader input) throws IOException {
        String line = input.readLine();
        if (line == null) return "";

        StringTokenizer st = new StringTokenizer(line);
        String wordA = st.nextToken();
        String wordB = st.nextToken();

        int n = wordA.length();
        int m = wordB.length();

        int intersectA = -1; // 단어 A에서의 교차 인덱스 (열 위치)
        int intersectB = -1; // 단어 B에서의 교차 인덱스 (행 위치)

        // 1. 교차 지점 찾기 (A에서 먼저 등장하는 순서 기준)
        outer:
        for (int i = 0; i < n; i++) {
            char target = wordA.charAt(i);
            for (int j = 0; j < m; j++) {
                if (target == wordB.charAt(j)) {
                    intersectA = i;
                    intersectB = j;
                    break outer; // 가장 먼저 발견된 지점에서 정지
                }
            }
        }

        // 2. 결과 그리드 생성
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == intersectB) {
                    // 교차 행인 경우 단어 A 출력
                    sb.append(wordA.charAt(j));
                } else if (j == intersectA) {
                    // 교차 열인 경우 단어 B 출력
                    sb.append(wordB.charAt(i));
                } else {
                    // 나머지는 마침표
                    sb.append('.');
                }
            }
            // 마지막 줄이 아닐 때만 줄바꿈 추가
            if (i < m - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
