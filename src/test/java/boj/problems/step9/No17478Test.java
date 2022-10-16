package boj.problems.step9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No17478Test {
    public static final int TESTCASE_NUM = 2;

    File path = new File(".");
    String[] input = new String[TESTCASE_NUM];
    String[] output = new String[TESTCASE_NUM];

    @Test
    @DisplayName("재귀함수가 뭔가요?")
    void 재귀함수가_뭔가요__테스트() throws IOException {
        System.out.println("재귀함수가 뭔가요? : https://www.acmicpc.net/problem/17478");
        setTestCase();
        for (int i = 0; i < TESTCASE_NUM; i++) {
            BufferedReader given = new BufferedReader(new FileReader(input[i]));
            String expected = new String(Files.readAllBytes(new File(output[i]).toPath()));
            assertEquals(expected, No17478.solve(given));
            given.close();
        }
    }

    private void setTestCase() {
        input[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step9/No17478_input_1.txt";
        output[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step9/No17478_output_1.txt";
        input[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step9/No17478_input_2.txt";
        output[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step9/No17478_output_2.txt";
    }
}
