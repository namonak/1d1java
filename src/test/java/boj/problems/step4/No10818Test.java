package boj.problems.step4;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No10818Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No10818_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No10818_output.txt";

    @Test
    @DisplayName("최소, 최대")
    void test() throws IOException {
        System.out.println("최소, 최대 : https://www.acmicpc.net/problem/10818");

        // given
        BufferedReader br_given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = No10818.solve(br_given);

        // then
        assertEquals(expected, actual);

        br_given.close();
    }
}
