package boj.problems;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class No30457 {
    public static String solve(BufferedReader input) throws Exception {
        // 첫째 줄에서 학생의 수 N을 읽어옵니다.
        int n = Integer.parseInt(input.readLine().trim());

        // 둘째 줄에서 학생들의 키 데이터를 읽어옵니다.
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        // 키의 범위가 1부터 1000까지이므로, 빈도를 저장할 배열을 1001 크기로 할당합니다.
        int[] counts = new int[1001];
        for (int i = 0; i < n; i++) {
            counts[Integer.parseInt(st.nextToken())]++;
        }

        int maxStudents = 0;

        // 각 키별로 최대 2명까지만 단체줄넘기에 참여할 수 있습니다.
        for (int i = 1; i <= 1000; i++) {
            maxStudents += Math.min(counts[i], 2);
        }

        // 최종적으로 계산된 최대 학생 수를 문자열로 반환합니다.
        return String.valueOf(maxStudents);
    }
}
