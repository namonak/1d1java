package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No14681Test {
    @DisplayName("사분면 고르기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"'12\n5\n':1", "'9\n-13\n':4"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("사분면 고르기 : https://www.acmicpc.net/problem/14681");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No14681.solve(br_given)));

        br_given.close();
    }
}
