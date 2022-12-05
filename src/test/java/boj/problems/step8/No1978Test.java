package boj.problems.step8;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No1978Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step8/No1978_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step8/No1978_output.txt";

    @Test
    @DisplayName("소수 찾기 테스트")
    void test() throws IOException {
        System.out.println("소수 찾기 : https://www.acmicpc.net/problem/1978");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        int actual = No1978.solve(given);

        // then
        assertEquals(expected, String.valueOf(actual));

        given.close();
    }
}
