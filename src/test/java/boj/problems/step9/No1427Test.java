package boj.problems.step9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1427Test {
    @DisplayName("소트인사이드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2143:4321", "999998999:999999998", "61423:64321", "500613009:965310000"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("소트인사이드 : https://www.acmicpc.net/problem/1427");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, No1427.solve(br_given));

        br_given.close();
    }
}
