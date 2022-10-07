package boj.problems.step10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No10870Test {
    @DisplayName("피보나치 수 5 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10:55"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("피보나치 수 5 : https://www.acmicpc.net/problem/10870");

        BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(given)));

        assertEquals(expected, String.valueOf(No10870.solve(br_given)));

        br_given.close();
    }
}
