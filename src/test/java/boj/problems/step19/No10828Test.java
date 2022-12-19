package boj.problems.step19;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No10828Test {
    public static final int TESTCASE_NUM = 2;

    File path = new File(".");
    String[] input = new String[TESTCASE_NUM];
    String[] output = new String[TESTCASE_NUM];

    @Test
    @DisplayName("스택")
    void test() throws IOException {
        System.out.println("스택 : https://www.acmicpc.net/problem/10828");

        input[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_input_1.txt";
        output[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_output_1.txt";
        input[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_input_2.txt";
        output[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_output_2.txt";

        for (int i = 0; i < TESTCASE_NUM; i++) {
            // given
            BufferedReader given = new BufferedReader(new FileReader(input[i]));
            String expected = new String(Files.readAllBytes(new File(output[i]).toPath()));

            // when
            String actual = No10828.solve(given);

            // then
            assertEquals(expected, actual);

            given.close();
        }
    }
}
