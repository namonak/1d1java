package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2525Test {
    @DisplayName("오븐 시계 테스트")
    @ParameterizedTest
    @CsvSource (value = {"'14 30\n20':14 50", "'17 40\n80':19 0", "'23 48\n25':0 13"}, delimiter = ':')
    void 오븐_시계_테스트(String given, String expected) throws IOException {
        System.out.println("오븐 시계 : https://www.acmicpc.net/problem/2525");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, No2525.solve(br_given));

        br_given.close();
    }
}