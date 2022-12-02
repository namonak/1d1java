package boj.problems.step11;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class No25305Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No25305_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No25305_output.txt";

    @Test
    @DisplayName("커트라인 테스트")
    void test() throws IOException {
        System.out.println("커트라인 : https://www.acmicpc.net/problem/25305");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(String.valueOf(No25305.solve(given))).isEqualTo(expected);

        given.close();
    }
}
