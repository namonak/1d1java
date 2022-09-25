package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1330Test {
    @DisplayName("두 수 비교하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 2:<", "10 2:>", "5 5:=="}, delimiter = ':')
    void test(String input, String expected) throws IOException {
        System.out.println("두 수 비교하기 : https://www.acmicpc.net/problem/1330");

        BufferedReader br_given = new BufferedReader(new StringReader(input));

        assertEquals(expected, No1330.solve(br_given));

        br_given.close();
    }
}
