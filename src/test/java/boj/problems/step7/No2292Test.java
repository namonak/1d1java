package boj.problems.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No2292Test {
    @DisplayName("벌집 테스트")
    @ParameterizedTest
    @CsvSource(value = {"13:3", "1:1", "2:2", "7:2", "5:2", "37:4", "38:5", "64:6"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("벌집 : https://www.acmicpc.net/problem/2292");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No2292.solve(br_given)));

        br_given.close();
    }
}
