package boj.problems.step22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No1920Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step22/No1920_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step22/No1920_output.txt";

    @Test
    @DisplayName("수 찾기")
    void test() throws IOException {
        System.out.println("수 찾기 : https://www.acmicpc.net/problem/1920");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = new String(No1920.solve(given));

        // then
        assertEquals(expected, actual);

        given.close();
    }
}
