package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No2739Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No2739_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No2739_output.txt";

    @Test
    @DisplayName("구구단")
    void test() throws IOException {
        System.out.println("곱셈 : https://www.acmicpc.net/problem/2739");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No2739.solve(given)).isEqualTo(expected);

        given.close();
    }
}
