package boj.problems.step11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No2751Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No2751_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No2751_output.txt";

    @Test
    @DisplayName("수 정렬하기 2 테스트")
    void test() throws IOException {
        System.out.println("수 정렬하기 2 : https://www.acmicpc.net/problem/2751");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = No2751.solve(given);

        // then
        assertThat(actual).isEqualTo(expected);
        given.close();
    }
}
