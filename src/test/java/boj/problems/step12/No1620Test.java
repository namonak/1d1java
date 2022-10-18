package boj.problems.step12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No1620Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step12/No1620_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step12/No1620_output.txt";

    @Test
    @DisplayName("나는야 포켓몬 마스터 이다솜")
    void test() throws IOException {
        System.out.println("나는야 포켓몬 마스터 이다솜 : https://www.acmicpc.net/problem/1620");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No1620.solve(given)).isEqualTo(expected);

        given.close();
    }
}
