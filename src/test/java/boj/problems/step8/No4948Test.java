package boj.problems.step8;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No4948Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step8/No4948_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step8/No4948_output.txt";

    @Test
    @DisplayName("베르트랑 공준 테스트")
    void test() throws IOException {
        System.out.println("베르트랑 공준 : https://www.acmicpc.net/problem/4948");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when, then
        //assertEquals(expected, No4948.solve(given));

        given.close();
    }
}
