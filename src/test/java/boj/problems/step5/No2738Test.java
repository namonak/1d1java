package boj.problems.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2738Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step5/No2738_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step5/No2738_output.txt";

    @Test
    @DisplayName("행렬 덧셈")
    void test() throws IOException {
        System.out.println("행렬 덧셈 : https://www.acmicpc.net/problem/2738");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertEquals(expected, No2738.solve(given));

        given.close();
    }
}
