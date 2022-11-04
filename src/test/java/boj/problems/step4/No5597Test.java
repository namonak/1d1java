package boj.problems.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No5597Test {
    public static final int TESTCASE_NUM = 2;

    File path = new File(".");
    String[] input = new String[TESTCASE_NUM];
    String[] output = new String[TESTCASE_NUM];

    @DisplayName("과제 안 내신 분..?")
    @Test
    void test() throws IOException {
        System.out.println("과제 안 내신 분..? : https://www.acmicpc.net/problem/5597");
        setInput();
        for (int i = 0; i < TESTCASE_NUM; ++i) {
            BufferedReader given = new BufferedReader(new java.io.FileReader(input[i]));
            String expected = new String(Files.readAllBytes(new File(output[i]).toPath()));
            assertThat(No5597.solve(given)).isEqualTo(expected);
            given.close();
        }
    }

    private void setInput() {
        input[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No5597_input_1.txt";
        output[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No5597_output_1.txt";
        input[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No5597_input_2.txt";
        output[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No5597_output_2.txt";
    }
}
