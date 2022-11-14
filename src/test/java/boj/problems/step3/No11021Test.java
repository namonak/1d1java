package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class No11021Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No11021_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No11021_output.txt";

    @Test
    @DisplayName("A+B - 7 테스트")
    void test() throws IOException {
        System.out.println("A+B - 7 : https://www.acmicpc.net/problem/11021");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(java.nio.file.Files.readAllBytes(new File(output).toPath()));

        assertThat(No11021.solve(given)).isEqualTo(expected);

        given.close();
    }
}
