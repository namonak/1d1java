package boj.problems.step3;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class No11022Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No11022_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No11022_output.txt";

    @Test
    @DisplayName("A+B - 8 테스트")
    void test() throws IOException {
        System.out.println("A+B - 8 : https://www.acmicpc.net/problem/11022");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No11022.solve(given)).isEqualTo(expected);

        given.close();
    }
}
