package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No23886 {
    public static String solve(BufferedReader input) throws IOException {
        String x = input.readLine();

        // 입력값이 비정상적인 경우 처리 (문제 조건상 길이는 3 이상)
        if (x == null || x.trim().isEmpty()) {
            return "NON ALPSOO";
        }
        x = x.trim();

        int n = x.length();
        int[] diff = new int[n - 1];

        // 1. 각 자리의 차이(기울기)를 구하며 평지가 있는지 확인
        for (int i = 0; i < n - 1; i++) {
            diff[i] = x.charAt(i + 1) - x.charAt(i);
            // 기울기가 0이면 평지이므로 알프수가 아님
            if (diff[i] == 0) {
                return "NON ALPSOO";
            }
        }

        // 2. 처음이 오르막(양의 기울기), 마지막이 내리막(음의 기울기)인지 확인
        if (diff[0] < 0 || diff[diff.length - 1] > 0) {
            return "NON ALPSOO";
        }

        // 3. 오르막 또는 내리막 구간 내에서 경사(기울기)가 일정한지 확인
        for (int i = 0; i < diff.length - 1; i++) {
            // 연속된 두 기울기의 부호가 같을 때 (즉, 같은 오르막이거나 같은 내리막 구간일 때)
            if ((diff[i] > 0 && diff[i + 1] > 0) || (diff[i] < 0 && diff[i + 1] < 0)) {
                // 경사가 달라지면 알프수가 아님
                if (diff[i] != diff[i + 1]) {
                    return "NON ALPSOO";
                }
            }
        }

        // 모든 조건을 통과하면 알프수
        return "ALPSOO";
    }
}
