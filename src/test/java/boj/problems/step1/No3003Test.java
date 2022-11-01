package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No3003Test {
    @DisplayName("킹, 퀸, 룩, 비숍, 나이트, 폰")
    @ParameterizedTest
    @CsvSource(value = {"0 1 2 2 2 7:1 0 0 0 0 1", "2 1 2 1 2 1:-1 0 0 1 0 7"}, delimiter = ':')
    void test(String given, String expected) throws IOException  {
        System.out.println("킹, 퀸, 룩, 비숍, 나이트, 폰 : https://www.acmicpc.net/problem/3003");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(No3003.solve(br_given)).isEqualTo(expected);

        br_given.close();
    }
}
