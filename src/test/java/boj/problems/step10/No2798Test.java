package boj.problems.step10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2798Test {
    @DisplayName("블랙잭 테스트")
    @ParameterizedTest
    @CsvSource(value = {"'5 21\n5 6 7 8 9':21", "'10 500\n93 181 245 214 315 36 185 138 216 295':497"}, delimiter = ':')
    void 블랙잭_테스트(String given, String expected) throws IOException {
        System.out.println("블랙잭 : https://www.acmicpc.net/problem/2798");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No2798.solve(br_given)));

        br_given.close();
    }
}
