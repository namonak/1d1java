package boj.problems.step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2884 {
    public static final int PRESET_TIME = 45;
    public static final int MIDNIGHT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
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