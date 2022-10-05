package boj.problems.step6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1157Test {
    @DisplayName("단어 공부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"Mississipi:?", "zZa:Z", "z:Z", "baaa:A"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("단어 공부 : https://www.acmicpc.net/problem/1157");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No1157.solve(br_given)));

        br_given.close();
    }
}
