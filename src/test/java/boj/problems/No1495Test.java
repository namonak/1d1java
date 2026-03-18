package boj.problems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class No1495Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("기타리스트 : https://www.acmicpc.net/problem/1495")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1495.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3 5 10\n" +
                        "5 3 7",
                        "10"
                ),
                arguments(
                        "4 8 20\n" +
                        "15 2 9 10",
                        "-1"
                ),
                arguments(
                        "14 40 243\n" +
                        "74 39 127 95 63 140 99 96 154 18 137 162 14 88",
                        "238"
                )
        );
    }
    // spotless:on
}
