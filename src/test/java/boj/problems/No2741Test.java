package boj.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class No2741Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/No2741_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/No2741_output.txt";

    @Test
    @DisplayName("N 찍기 테스트")
    void N_찍기_테스트() throws IOException {
        System.out.println("N 찍기 : https://www.acmicpc.net/problem/2741");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertThat(No2741.solve(given)).isEqualTo(expected);

        given.close();
    }
}
