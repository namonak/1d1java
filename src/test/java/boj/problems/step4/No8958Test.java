package boj.problems.step4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class No8958Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No8958_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step4/No8958_output.txt";

    @Test
    @DisplayName("OX퀴즈")
    void test() throws IOException {
        System.out.println("OX퀴즈 : https://www.acmicpc.net/problem/8958");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = No8958.solve(given);

        // then
        assertThat(actual).isEqualTo(expected);

        given.close();
    }
}
