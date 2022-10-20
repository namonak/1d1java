package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class No1003Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/No1003_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/No1003_output.txt";

    @Test
    @DisplayName("피보나치 함수 테스트")
    void test() throws IOException {
        System.out.println("피보나치 함수 : https://www.acmicpc.net/problem/1003");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No1003.solve(given)).isEqualTo(expected);

        given.close();
    }
}
