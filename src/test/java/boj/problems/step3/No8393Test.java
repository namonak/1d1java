package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

class No8393Test {
    @DisplayName("합 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:6", "4:10", "5:15", "6:21", "7:28", "8:36", "9:45", "10:55"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("합 : https://www.acmicpc.net/problem/8393");

        BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(given)));

        assertThat(String.valueOf(No8393.solve(br_given))).isEqualTo(expected);

        br_given.close();
    }
}
