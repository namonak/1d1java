package boj.problems.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No4344Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No4344_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No4344_output.txt";

    @Test
    @DisplayName("평균은 넘겠지 테스트")
    void test() throws IOException {
        System.out.println("평균은 넘겠지 : https://www.acmicpc.net/problem/4344");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = No4344.solve(given);

        // then
        assertEquals(expected, actual);

        given.close();
    }
}
