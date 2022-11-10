package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

class No10950Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No10950_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step3/No10950_output.txt";

    @Test
    @DisplayName("A+B - 3")
    void test() throws IOException {
        System.out.println("A+B - 3 : https://www.acmicpc.net/problem/10950");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No10950.solve(given)).isEqualTo(expected);

        given.close();
    }
}
