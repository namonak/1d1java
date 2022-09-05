package boj.problems.step22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        input.close();
        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int numOfLanCable = Integer.parseInt(st.nextToken());
        int numOfReq = Integer.parseInt(st.nextToken());
        int[] arrCables = new int[numOfLanCable];
        long max = 0;
        long min = 0;
        long mid = 0;

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

        output.write((min - 1) + "\n");
    }
}
