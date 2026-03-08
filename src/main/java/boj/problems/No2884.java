package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No2884 {
    public static final int PRESET_TIME = 45;
    public static final int MIDNIGHT = 0;

    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute < PRESET_TIME) {
            if (hour == MIDNIGHT) {
                hour = 23;
            } else {
                hour--;
            }
            minute = minute + 60 - PRESET_TIME;

            return hour + " " + minute;
        }

        return hour + " " + (minute - PRESET_TIME);
    }
}
