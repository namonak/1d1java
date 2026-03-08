package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1654 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int numOfLanCable = Integer.parseInt(st.nextToken());
        int numOfReq = Integer.parseInt(st.nextToken());
        int[] arrCables = new int[numOfLanCable];
        long max = 0;
        long min = 0;
        long mid;

        for (int i = 0; i < numOfLanCable; ++i) {
            arrCables[i] = Integer.parseInt(input.readLine());
            if (max <= arrCables[i]) {
                max = arrCables[i];
            }
        }

        max++;

        while (min < max) {
            long result = 0;
            mid = (min + max) / 2;
            for (int i = 0; i < numOfLanCable; ++i) {
                result += arrCables[i] / mid;
            }

            if (result < numOfReq) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return String.valueOf(min - 1);
    }
}
