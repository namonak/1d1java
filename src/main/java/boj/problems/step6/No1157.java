package boj.problems.step6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1157 {
    public static final int NUMBER_OF_LETTERS = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input) + "\n");

        input.close();
        output.flush();
        output.close();
    }

    static char solve(BufferedReader input) throws IOException {
        String str = input.readLine();
        int[] alphabet = new int[NUMBER_OF_LETTERS];

        for (int i = 0; i < str.length(); i++) {
            getAlphabetCount(str, alphabet, i);
        }

        return getResult(alphabet);
    }

    private static char getResult(int[] alphabet) {
        int maxIdx = -1;
        char result = '?';

        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
            if (alphabet[i] > maxIdx) {
                maxIdx = alphabet[i];
                result = (char) (i + 'A');
            }
            else if (alphabet[i] == maxIdx) {
                result = '?';
            }
        }
        return result;
    }

    private static void getAlphabetCount(String str, int[] alphabet, int i) {
        if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
            alphabet[str.charAt(i) - 'a']++;
        } else {
            alphabet[str.charAt(i) - 'A']++;
        }
    }
}
