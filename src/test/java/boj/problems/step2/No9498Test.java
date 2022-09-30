package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No9498Test {
    @DisplayName("시험 성적 테스트")
    @ParameterizedTest
    @CsvSource(value = {"100:A", "90:A", "89:B", "80:B", "79:C", "70:C", "69:D", "60:D", "59:F", "0:F"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("시험 성적 : https://www.acmicpc.net/problem/9498");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, No9498.solve(br_given));

        br_given.close();
    }
}
