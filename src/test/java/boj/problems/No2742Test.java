package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No2742Test {
    @DisplayName("기찍 N 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:'5\n4\n3\n2\n1'"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("기찍 N : https://www.acmicpc.net/problem/2742");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(No2742.solve(br_given)).isEqualTo(expected);

        br_given.close();
    }
}
