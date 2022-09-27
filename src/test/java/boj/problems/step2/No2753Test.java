package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2753Test {
    @DisplayName("윤년 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000:1", "1999:0", "1900:0"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("윤년 : https://www.acmicpc.net/problem/2753");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(Integer.parseInt(expected), No2753.solve(br_given));

        br_given.close();
    }
}