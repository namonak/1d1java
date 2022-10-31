package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No1085Test {
    @DisplayName("직사각형에서 탈출")
    @ParameterizedTest
    @CsvSource(value = {"6 2 10 3:1", "1 1 5 5:1", "653 375 1000 1000:347", "161 181 762 375:161"}, delimiter = ':')
    void test(String given, String expected) throws IOException  {
        System.out.println("직사각형에서 탈출 : https://www.acmicpc.net/problem/1085");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertThat(String.valueOf(No1085.solve(br_given))).isEqualTo(expected);

        br_given.close();
    }
}
