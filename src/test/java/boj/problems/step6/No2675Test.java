package boj.problems.step6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import static org.assertj.core.api.Assertions.assertThat;

public class No2675Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step6/No2675_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step6/No2675_output.txt";

    @Test
    @DisplayName("문자열 반복 테스트")
    void test() throws IOException {
        System.out.println("문자열 반복 : https://www.acmicpc.net/problem/2675");

        BufferedReader given = new BufferedReader(new FileReader(input));

        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No2675.solve(given)).isEqualTo(expected);

        given.close();
    }
}
