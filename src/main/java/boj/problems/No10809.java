package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class No10809 {
    public static final int ALPHABET_NUMBER = 26;

    public static String solve(BufferedReader input) throws IOException {
        String word = input.readLine();
        int[] alphabet = initAlphabetArray();

        updateAlphabetArray(word, alphabet);

        return makeResult(alphabet);
    }

    private static String makeResult(int[] alphabet) {
        StringBuilder sb = new StringBuilder();
        for (int j : alphabet) {
            sb.append(j).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static void updateAlphabetArray(String word, int[] alphabet) {
        for (int i = 0; i < word.length(); i++) {
            checkWordIndex(word, alphabet, i);
        }
    }

    private static void checkWordIndex(String word, int[] alphabet, int i) {
        int index = word.charAt(i) - 'a';
        if (alphabet[index] == -1) {
            alphabet[index] = i;
        }
    }

    private static int[] initAlphabetArray() {
        int[] alphabet = new int[ALPHABET_NUMBER];
        Arrays.fill(alphabet, -1);
        return alphabet;
    }
}
