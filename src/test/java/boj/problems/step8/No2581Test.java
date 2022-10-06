package boj.problems.step8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2581Test {
    @DisplayName("소수 테스트")
    @ParameterizedTest
    @CsvSource (value = {"'60\n100':'620\n61'", "'64\n65':-1"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("소수 : https://www.acmicpc.net/problem/2581");

        BufferedReader br_given = new BufferedReader(new StringReader(given));

        assertEquals(expected, No2581.solve(br_given));

        br_given.close();
    }
}
