package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2480Test {
    @DisplayName("주사위 세개 테스트")
    @ParameterizedTest
    @CsvSource (value = {"3 3 6:1300", "2 2 2:12000", "6 2 5:600"}, delimiter = ':')
    void 주사위_세개_테스트(String given, String expected) throws IOException {
        System.out.println("주사위 세게 : https://www.acmicpc.net/problem/2480");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No2480.solve(br_given)));

        br_given.close();
    }
}
