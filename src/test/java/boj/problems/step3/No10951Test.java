package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

class No10951Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No10951_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No10951_output.txt";

    @Test
    @DisplayName("A+B - 4 테스트")
    void test() throws IOException {
        System.out.println("A+B - 4 : https://www.acmicpc.net/problem/10951");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No10951.solve(given)).isEqualTo(expected);

        given.close();
    }
}
