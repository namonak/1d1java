package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1001Test {
    @DisplayName("A-B 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 2:-1", "5 5:0", "100 101:-1", "1 7:-6", "12 29:-17"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("A-B : https://www.acmicpc.net/problem/1001");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No1001.solve(br_given)));

        br_given.close();
    }
}