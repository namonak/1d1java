package boj.problems.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No3052Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No3052_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No3052_output.txt";

    @Test
    @DisplayName("나머지 테스트")
    void test() throws IOException {
        System.out.println("나머지 : https://www.acmicpc.net/problem/3052");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = String.valueOf(No3052.solve(given));

        // then
        assertEquals(expected, actual);

        given.close();
    }
}
