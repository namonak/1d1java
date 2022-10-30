package boj.problems.step6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10809 {
    public static final int ALPHABET_NUMBER = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) {
        String word = checkInput(input);
        int[] alphabet = initAlphabetArray();

        updateAlphabetArray(word, alphabet);

        return makeResult(alphabet);
    }

    private static String makeResult(int[] alphabet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]).append(" ");
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
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }
        return alphabet;
    }

    private static String checkInput(BufferedReader input) {
        String word = null;
        try {
            word = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }
}
