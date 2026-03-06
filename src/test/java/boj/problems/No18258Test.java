package boj.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class No18258Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/No18258_input.txt";
    String output =
            path.getAbsolutePath() + "/src/test/java/boj/problems/No18258_output.txt";

    @Test
    @DisplayName("큐 2 테스트")
    void test() throws IOException {
        System.out.println("큐 2 : https://www.acmicpc.net/problem/18258");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertEquals(expected, No18258.solve(given));

        given.close();
    }
}
