package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1712Test {
    @DisplayName("손익분기점 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000 70 170:11", "3 2 1:-1", "2100000000 9 10:2100000001"}, delimiter = ':')
    void 손익분기점_테스트(String given, String expected) throws IOException {
        System.out.println("손익분기점 : https://www.acmicpc.net/problem/1712");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No1712.solve(br_given)));

        br_given.close();
    }
}
