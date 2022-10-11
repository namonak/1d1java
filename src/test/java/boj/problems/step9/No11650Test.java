package boj.problems.step9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.reporters.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No11650Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step9/No11650_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step9/No11650_output.txt";

    @Test
    @DisplayName("좌표 정렬하기")
    void 좌표_정렬하기_테스트() throws IOException {
        System.out.println("좌표 정렬하기 : https://www.acmicpc.net/problem/11650");

        BufferedReader given = new BufferedReader(new FileReader(input));
        File expected = new File(output);

        assertEquals(Files.readFile(expected), No11650.solve(given));

        given.close();
    }
}
