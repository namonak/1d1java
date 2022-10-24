package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No10430Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step1/No10430_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step1/No10430_output.txt";

    @Test
    @DisplayName("나머지")
    void 나머지_테스트() throws IOException {
        System.out.println("나머지 : https://www.acmicpc.net/problem/10430");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No10430.solve(given)).isEqualTo(expected);

        given.close();
    }
}
