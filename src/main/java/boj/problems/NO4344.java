package boj.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class No4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    public static double getAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    private static int[] getScores(StringTokenizer st) {
        int numberOfScores = Integer.parseInt(st.nextToken());
        int scores[] = new int[numberOfScores];

        for (int i = 0; i < numberOfScores; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        return scores;
    }

    private static int getRate(int[] scores, double average) {
        int rate = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > average) {
                rate++;
            }
        }
        return rate;
    }

    private static String getResult(int rate, int total) {
        double result = ((double)rate/total) * 100;
        String formattedResult = String.format("%.3f", result);

        return formattedResult;
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int testCase = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int[] scores = getScores(st);
            String formattedResult = getResult(getRate(scores, getAverage(scores)), scores.length);
            output.write(formattedResult + "%\n");
        }
    }
}
