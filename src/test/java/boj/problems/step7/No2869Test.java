package boj.problems.step7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No2869Test {
    @DisplayName("달팽이는 올라가고 싶다 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 1 5:4", "5 1 6:2", "100 99 1000000000:999999901"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("달팽이는 올라가고 싶다 : https://www.acmicpc.net/problem/2869");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No2869.solve(br_given)));

        br_given.close();
    }
}
