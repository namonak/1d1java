package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No17211 {
    public static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int currentMood = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        double pGG = Double.parseDouble(st.nextToken());
        double pGB = Double.parseDouble(st.nextToken());
        double pBG = Double.parseDouble(st.nextToken());
        double pBB = Double.parseDouble(st.nextToken());

        double good;
        double bad;

        if (currentMood == 0) {
            good = 1.0;
            bad = 0.0;
        } else {
            good = 0.0;
            bad = 1.0;
        }

        for (int day = 0; day < n; day++) {
            double nextGood = good * pGG + bad * pBG;
            double nextBad = good * pGB + bad * pBB;
            good = nextGood;
            bad = nextBad;
        }

        long goodAnswer = Math.round(good * 1000.0);
        long badAnswer = Math.round(bad * 1000.0);

        return String.valueOf(goodAnswer) + '\n' + badAnswer;
    }
}
