package boj.problems.step6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No2908Test {
    @DisplayName("상수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"734 893:437", "221 231:132", "839 237:938"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("상수 : https://www.acmicpc.net/problem/2908");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(String.valueOf(No2908.solve(br_given))).isEqualTo(expected);

        br_given.close();
    }
}
