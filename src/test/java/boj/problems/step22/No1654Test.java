package boj.problems.step22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No1654Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step22/No1654_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step22/No1654_output.txt";

    @Test
    @DisplayName("랜선 자르기")
    void test() throws IOException {
        System.out.println("랜선 자르기 : https://www.acmicpc.net/problem/1654");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(String.valueOf(No1654.solve(given))).isEqualTo(expected);

        given.close();
    }
}
