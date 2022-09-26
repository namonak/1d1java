package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1000Test {
    @DisplayName("A+B 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 2:3", "5 5:10", "100 101:201", "1 7:8", "12 29:41"}, delimiter = ':')
    void test(String input, String expected) throws IOException {
        System.out.println("A+B : https://www.acmicpc.net/problem/1000");

        BufferedReader br_given = new BufferedReader(new StringReader(input));

        assertEquals(expected, String.valueOf(No1000.solve(br_given)));

        br_given.close();
    }
}