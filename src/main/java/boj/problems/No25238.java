package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No25238 {
    public static String solve(BufferedReader input) throws IOException {
        String line = input.readLine();
        if (line == null) return "";

        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 체감 방어율 계산 (실수 연산을 위해 100.0으로 나눔)
        double effectiveArmor = a * (100 - b) / 100.0;

        // 체감 방어율이 100보다 크거나 같으면 데미지를 줄 수 없음 (0)
        // 100보다 작으면 데미지를 줄 수 있음 (1)
        if (effectiveArmor >= 100.0) {
            return "0";
        } else {
            return "1";
        }
    }
}
