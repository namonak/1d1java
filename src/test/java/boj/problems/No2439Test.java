package boj.problems;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class No2439Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/No2439_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/No2439_output.txt";

    @Test
    @DisplayName("별 찍기 - 2 테스트")
    void test() throws IOException {
        System.out.println("별 찍기 - 2 : https://www.acmicpc.net/problem/2439");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No2439.solve(given)).isEqualTo(expected);

        given.close();
    }
}
