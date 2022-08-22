package boj.problems.step10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int givenNumber = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        output.write(getResult(arr, n, givenNumber) + "\n");
    }

    private static int getResult(int[] arr, int n, int givenNumber) {
        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            if (arr[i] > givenNumber) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[i] + arr[j] > givenNumber) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];

                    if (temp == givenNumber) {
                        return temp;
                    }

                    if (temp > result && temp < givenNumber) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }
}
