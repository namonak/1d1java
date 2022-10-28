package boj.problems.step5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[N][M];
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            String[] tmp = input.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            String[] tmp = input.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                sb.append((matrixA[i][j] += Integer.parseInt(tmp[j])) + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
