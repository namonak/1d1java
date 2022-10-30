package boj.problems.step6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No10809Test {
    @DisplayName("알파벳 찾기")
    @ParameterizedTest
    @CsvSource(value = {"baekjoon:1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("알파벳 찾기 : https://www.acmicpc.net/problem/10809");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(No10809.solve(br_given)).isEqualTo(expected);

        br_given.close();
    }
}
