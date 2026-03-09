package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2869 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        long up = Long.parseLong(st.nextToken());
        long down = Long.parseLong(st.nextToken());
        long length = Long.parseLong(st.nextToken());
        long dailyGain = up - down;
        if (dailyGain <= 0) {
            throw new IllegalArgumentException("up must be greater than down.");
        }

        long day = (length - down) / dailyGain;
        if ((length - down) % dailyGain != 0) {
            day++;
        }
        return String.valueOf(day);
    }
}
