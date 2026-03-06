package boj.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class No2231Test {
    @DisplayName("분해합 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"216:198"},
            delimiter = ':')
    void 분해합_테스트(String given, String expected) throws IOException {
        System.out.println("분해합 : https://www.acmicpc.net/problem/2231");

        BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(given)));

        assertEquals(expected, String.valueOf(No2231.solve(br_given)));

        br_given.close();
    }
}
