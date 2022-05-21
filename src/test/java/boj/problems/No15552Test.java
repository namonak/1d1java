package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

import static junit.framework.TestCase.assertEquals;

public class No15552Test {
    @Test
    @DisplayName("빠른 A+B 테스트")
    void 빠른_A_더하기_B_테스트() {
        File path = new File(".");
        String input = path.getAbsolutePath() + "/src/test/java/boj/problems/No15552_input.txt";
        String output = path.getAbsolutePath() + "/src/test/java/boj/problems/No15552_output.txt";

        try {
            BufferedReader given = new BufferedReader(new FileReader(input));
            BufferedReader want = new BufferedReader(new FileReader(output));
            StringWriter sw = new StringWriter();
            BufferedWriter bw = new BufferedWriter(sw);

            No15552.solve(given, bw);

            bw.close();

            BufferedReader actual = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            assertEquals(actual.read(), want.read());
            assertEquals(actual.read(), want.read());
            assertEquals(actual.read(), want.read());
            assertEquals(actual.read(), want.read());
            assertEquals(actual.read(), want.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
