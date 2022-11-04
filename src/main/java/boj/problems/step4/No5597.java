package boj.problems.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class No5597 {
    public static final int NUMBER_OF_STUDENTS = 30;
    public static final int CLASS_BOOK_NUMBER = 28;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        boolean[] classBook = makeClassBook(input);

        return getResult(classBook);
    }

    private static String getResult(boolean[] classBook) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_STUDENTS; ++i) {
            isAttend(classBook, sb, i);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static void isAttend(boolean[] classBook, StringBuilder sb, int i) {
        if (!classBook[i]) {
            sb.append(i + 1).append("\n");
        }
    }

    private static boolean[] makeClassBook(BufferedReader input) throws IOException {
        boolean[] classBook = new boolean[NUMBER_OF_STUDENTS];

        for (int i = 0; i < CLASS_BOOK_NUMBER; ++i) {
            classBook[Integer.parseInt(input.readLine()) - 1] = true;
        }
        return classBook;
    }
}
