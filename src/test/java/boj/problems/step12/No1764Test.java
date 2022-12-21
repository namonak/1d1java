package boj.problems.step12;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No1764Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step12/No1764_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step12/No1764_output.txt";

    @Test
    @DisplayName("듣보잡 테스트")
    void test() throws IOException {
        System.out.println("듣보잡 : https://www.acmicpc.net/problem/1764");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = No1764.solve(given);

        // then
        assertEquals(expected, actual);

        given.close();
    }
}
