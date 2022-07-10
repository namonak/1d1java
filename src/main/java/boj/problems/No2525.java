package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2525 {
    public static final int ONE_HOUR = 60;
    public static final int ONE_DAY = 24;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int timeToAdd = Integer.parseInt(input.readLine());

        minute += timeToAdd;
        
        if (minute >= ONE_HOUR) {
            hour += minute / ONE_HOUR;
            minute %= ONE_HOUR;
        }

        if (hour >= ONE_DAY) {
            hour %= ONE_DAY;
        }

        output.write(hour + " " + minute + "\n");
    }
}
