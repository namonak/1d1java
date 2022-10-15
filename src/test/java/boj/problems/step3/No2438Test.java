package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2438Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No2438_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No2438_output.txt";

    @Test
    @DisplayName("별 찍기 - 1 테스트")
    void test() throws IOException {
        System.out.println("별 찍기 - 1 : https://www.acmicpc.net/problem/2438");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertEquals(expected, No2438.solve(given));

        given.close();
    }
}
