package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1008Test {
    @Test
    @DisplayName("A/B 테스트")
    void A_나누기_B_테스트() throws IOException {
        System.out.println("A/B : https://www.acmicpc.net/problem/1008");

        BufferedReader br_given = new BufferedReader(new StringReader("1 3"));
        StringWriter sw = new StringWriter();
        BufferedWriter bw_got = new BufferedWriter(sw);

        No1008.solve(br_given, bw_got);

        bw_got.close();

        BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

        double got = Double.parseDouble(br_got.lines().collect(Collectors.joining()));

        assertEquals((double)1/3, got);
    }
}