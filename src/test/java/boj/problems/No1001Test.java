package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1001Test {
    @Test
    @DisplayName("A-B 테스트")
    void A_빼기_B_테스트() throws IOException {
        System.out.println("A-B : https://www.acmicpc.net/problem/1001");

        BufferedReader br_given = new BufferedReader(new StringReader("3 2"));
        StringWriter sw = new StringWriter();
        BufferedWriter bw_got = new BufferedWriter(sw);

        No1001.solve(br_given, bw_got);

        bw_got.close();

        BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

        int got = Integer.parseInt(br_got.lines().collect(Collectors.joining()));

        assertEquals(1, got);
    }
}
