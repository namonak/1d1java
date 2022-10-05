package boj.problems.step6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1152Test {
    @DisplayName("단어의 개수 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "The Curious Case of Benjamin Button:6",
            "The first character is a blank:6",
            "The last character is a blank:6",
            "Mazatneunde Wae Teullyeoyo:3",
            "Teullinika Teullyeotzi:2",
    }, delimiter = ':')
    void test(String given, String expected) throws IOException {
        System.out.println("단어의 개수 : https://www.acmicpc.net/problem/1152");

        BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(given)));

        assertEquals(expected, String.valueOf(No1152.solve(br_given)));
    }
}
