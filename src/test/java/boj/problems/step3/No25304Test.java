package boj.problems.step3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class No25304Test {
    public static final int TESTCASE_NUM = 2;

    File path = new File(".");
    String[] input = new String[TESTCASE_NUM];
    String[] output = new String[TESTCASE_NUM];

    @Test
    @DisplayName("영수증")
    void test() throws IOException {
        System.out.println("영수증 : https://www.acmicpc.net/problem/25304");
        setInput();
        for (int i = 0; i < TESTCASE_NUM; i++) {
            BufferedReader given = new BufferedReader(new FileReader(input[i]));
            String expected = new String(Files.readAllBytes(new File(output[i]).toPath()));
            assertThat(No25304.solve(given)).isEqualTo(expected);
            given.close();

        }
    }

    private void setInput() {
        input[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No25304_input_1.txt";
        output[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No25304_output_1.txt";
        input[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No25304_input_2.txt";
        output[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No25304_output_2.txt";
    }
}
