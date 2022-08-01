package boj.problems.step19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No10828Test {
    public static final int TESTCASE_NUM = 2;

    File path = new File(".");
    String[] input = new String[TESTCASE_NUM];
    String[] output = new String[TESTCASE_NUM];

    @Test
    @DisplayName("스택")
    void 스택_테스트() throws IOException {
        System.out.println("스택 : https://www.acmicpc.net/problem/10828");

        input[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_input_1.txt";
        output[0] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_output_1.txt";
        input[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_input_2.txt";
        output[1] = path.getAbsolutePath() + "/src/test/java/boj/problems/step19/No10828_output_2.txt";

        for (int i = 0; i < TESTCASE_NUM; i++) {
            BufferedReader br_given = new BufferedReader(new FileReader(input[i]));
            BufferedReader br_want = new BufferedReader(new FileReader(output[i]));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No10828.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
