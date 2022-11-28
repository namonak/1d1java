package boj.problems.step11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

class No10989Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No10989_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No10989_output.txt";

    @Test
    @DisplayName("수 정렬하기 3 테스트")
    void test() throws IOException {
        System.out.println("수 정렬하기 3 : https://www.acmicpc.net/problem/10989");

        // given
        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        // when
        String actual = No10989.solve(given);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
