package boj.problems.step9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No10872Test {
    @DisplayName("팩토리얼 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10:3628800", "0:1"}, delimiter = ':')
    void 팩토리얼_테스트(String given, String expected) throws IOException {
        System.out.println("팩토리얼 : https://www.acmicpc.net/problem/10872");

        BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(given)));

        assertEquals(expected, String.valueOf(No10872.solve(br_given)));

        br_given.close();
    }
}
