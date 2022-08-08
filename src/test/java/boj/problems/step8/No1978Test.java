package boj.problems.step8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1978Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/step8/No1978_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/step8/No1978_output.txt";

    @Test
    @DisplayName("소수 찾기 테스트")
    void 소수_찾기_테스트() throws IOException {
        System.out.println("소수 찾기 : https://www.acmicpc.net/problem/1978");

        BufferedReader br_given = new BufferedReader(new FileReader(input));
        BufferedReader br_want = new BufferedReader(new FileReader(output));
        StringWriter sw = new StringWriter();4
        BufferedWriter bw_got = new BufferedWriter(sw);

        No1978.solve(br_given, bw_got);

        bw_got.close();

        BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

        String got = br_got.lines().collect(Collectors.joining());
        String want = br_want.lines().collect(Collectors.joining());

        assertEquals(want, got);
    }
}
