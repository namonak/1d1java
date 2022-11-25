package boj.problems.step7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

class No10757Test {
    @DisplayName("큰 수 A+B 테스트")
    @ParameterizedTest
    @CsvSource(value = {"9223372036854775807 9223372036854775808:18446744073709551615"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("큰 수 A+B : https://www.acmicpc.net/problem/10757");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(No10757.solve(br_given)).isEqualTo(expected);

        br_given.close();
    }
}
