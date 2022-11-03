package boj.problems.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No10807Test {
    @DisplayName("개수 세기")
    @ParameterizedTest
    @CsvSource(value = {"'11\n1 4 1 2 4 2 4 2 3 4 4\n2':3", "'11\n1 4 1 2 4 2 4 2 3 4 4\n5':0"}, delimiter = ':')
    void test(String given, String expected) throws IOException  {
        System.out.println("개수 세기 : https://www.acmicpc.net/problem/10807");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(String.valueOf(No10807.solve(br_given))).isEqualTo(expected);

        br_given.close();
    }
}
