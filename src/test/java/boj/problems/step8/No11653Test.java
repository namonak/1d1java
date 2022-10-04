package boj.problems.step8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No11653Test {
    @DisplayName("소인수분해 테스트")
    @ParameterizedTest
    @CsvSource(value = {"72:'2\n2\n2\n3\n3\n'", "3:'3\n'", "6:'2\n3\n'", "2:'2\n'", "9991:'97\n103\n'"}, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("소인수분해 : https://www.acmicpc.net/problem/11653");

        BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(given)));

        assertEquals(expected, No11653.solve(br_given));

        br_given.close();
    }
}
