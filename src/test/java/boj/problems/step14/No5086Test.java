package boj.problems.step14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class No5086Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step14/No5086_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step14/No5086_output.txt";

    @Test
    @DisplayName("배수와 약수")
    void test() throws IOException {
        System.out.println("배수와 약수 : https://www.acmicpc.net/problem/5086");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = No5086.solve(given);

        // then
        assertThat(actual).isEqualTo(expected);

        given.close();
    }
}
