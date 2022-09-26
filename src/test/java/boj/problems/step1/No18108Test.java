package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No18108Test {
    @DisplayName("1998년생인 내가 태국에서는 2541년생?! 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2541:1998"}, delimiter = ':')
    void No18108_테스트(String given, String expected) throws IOException {
        System.out.println("1998년생인 내가 태국에서는 2541년생?! : https://www.acmicpc.net/problem/18108");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, String.valueOf(No18108.solve(br_given)));

        br_given.close();
    }
}
