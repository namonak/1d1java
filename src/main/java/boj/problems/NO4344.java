package boj.problems;

import java.io.IOException;

public class NO4344 {
    public static double getAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public static void main(String[] args) throws IOException {

    }
}
