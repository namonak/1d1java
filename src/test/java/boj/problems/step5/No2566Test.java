package boj.problems.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2566Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step5/No2566_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step5/No2566_output.txt";

    @Test
    @DisplayName("최댓값")
    void test() throws IOException {
        System.out.println("행렬 덧셈 : https://www.acmicpc.net/problem/2566");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertEquals(expected, No2566.solve(given));

        given.close();
    }
}
