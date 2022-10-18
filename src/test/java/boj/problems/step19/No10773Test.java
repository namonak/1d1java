package boj.problems.step19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No10773Test {
    @DisplayName("제로")
    @ParameterizedTest
    @CsvSource(value = {"'4\n3\n0\n4\n0':0", "'10\n1\n3\n5\n4\n0\n0\n7\n0\n0\n6':7", "'0\n0\n0\n':0"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("제로 : https://www.acmicpc.net/problem/10773");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(String.valueOf(No10773.solve(br_given))).isEqualTo(expected);

        br_given.close();
    }
}
