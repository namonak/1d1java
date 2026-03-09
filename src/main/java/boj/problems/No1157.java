package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No1157 {
    public static final int NUMBER_OF_LETTERS = 26;

    public static String solve(BufferedReader input) throws IOException {
        String str = input.readLine();
        int[] alphabet = new int[NUMBER_OF_LETTERS];

        for (int i = 0; i < str.length(); i++) {
            getAlphabetCount(str, alphabet, i);
        }

        return String.valueOf(getResult(alphabet));
    }

    private static char getResult(int[] alphabet) {
        int maxIdx = -1;
        char result = '?';

        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
            if (alphabet[i] > maxIdx) {
                maxIdx = alphabet[i];
                result = (char) (i + 'A');
            } else if (alphabet[i] == maxIdx) {
                result = '?';
            }
        }
        return result;
    }

    private static void getAlphabetCount(String str, int[] alphabet, int i) {
        char letter = str.charAt(i);

        if ('a' <= letter && letter <= 'z') {
            alphabet[letter - 'a']++;
            return;
        }

        if ('A' <= letter && letter <= 'Z') {
            alphabet[letter - 'A']++;
        }
    }
}
