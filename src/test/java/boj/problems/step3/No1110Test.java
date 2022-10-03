package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1110Test {
    @DisplayName("더하기 사이클 테스트")
    @ParameterizedTest
    @CsvSource(value = {"26:4", "55:3", "1:60", "0:1", "71:12"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("더하기 사이클 : https://www.acmicpc.net/problem/1110");

        BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(given)));

        assertEquals(expected, String.valueOf(No1110.solve(br_given)));

        br_given.close();
    }
}
