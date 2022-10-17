package boj.problems.step11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2750Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No2750_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step11/No2750_output.txt";

    @Test
    @DisplayName("수 정렬하기 테스트")
    void 수_정렬하기_테스트() throws IOException {
        System.out.println("수 정렬하기 : https://www.acmicpc.net/problem/2750");

        BufferedReader given = new BufferedReader(new FileReader(input));
        String expected = new String(Files.readAllBytes(new File(output).toPath()));

        assertEquals(expected, No2750.solve(given));

        given.close();
    }
}
