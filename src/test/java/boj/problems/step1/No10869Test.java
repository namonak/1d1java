package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No10869Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step1/No10869_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step1/No10869_output.txt";

    @Test
    @DisplayName("사칙연산 테스트")
    void test() throws IOException {
        System.out.println("사칙연산 : https://www.acmicpc.net/problem/10869");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No10869.solve(given)).isEqualTo(expected);

        given.close();
    }
}
