package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2884Test {
    @DisplayName("알람 시계 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 10:9 25", "0 30:23 45", "23 40:22 55"}, delimiter = ':')
    void 알람_시계_테스트(String given, String expected) throws IOException {
        System.out.println("알람 시계 : https://www.acmicpc.net/problem/2884");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, No2884.solve(br_given));

        br_given.close();
    }
}