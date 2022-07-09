package boj.problems;

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

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
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

            output.write(hour + " " + minute + "\n");

            return;
        }

        output.write(hour + " " + (minute - PRESET_TIME) + "\n");
    }
}
