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
        long maxLength = 0;

        for (int i = 0; i < numOfLanCable; ++i) {
            arrCables[i] = Integer.parseInt(input.readLine());
            if (maxLength < arrCables[i]) {
                maxLength = arrCables[i];
            }
        }

        long left = 1;
        long right = maxLength;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long result = getLanCableCount(arrCables, mid);

            if (result >= numOfReq) {
                answer = mid;
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }

        return String.valueOf(answer);
    }

    private static long getLanCableCount(int[] arrCables, long cableLength) {
        long result = 0;
        for (int cable : arrCables) {
            result += cable / cableLength;
        }
        return result;
    }
}
