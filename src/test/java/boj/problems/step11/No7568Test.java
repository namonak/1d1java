package boj.problems.step11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class No7568Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No7568_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No7568_output.txt";

    @Test
    @DisplayName("덩치 테스트")
    void test() throws IOException {
        System.out.println("덩치 : https://www.acmicpc.net/problem/7568");

        BufferedReader given = new BufferedReader(new FileReader(input));

        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        //assertThat(No2675.solve(given)).isEqualTo(expected);

        given.close();
    }
}
