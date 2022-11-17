package boj.problems.step3;

import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class No15552Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No15552_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No15552_output.txt";

    @Test
    @DisplayName("빠른 A+B 테스트")
    void test() throws IOException {
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No15552.solve(given)).isEqualTo(expected);

        given.close();
    }
}
