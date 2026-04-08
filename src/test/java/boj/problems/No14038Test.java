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

class No14038Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("Tournament Selection : https://www.acmicpc.net/problem/14038")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No14038.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "W\n" +
                        "L\n" +
                        "W\n" +
                        "W\n" +
                        "L\n" +
                        "W",
                        "2"
                ),
                arguments(
                        "L\n" +
                        "L\n" +
                        "L\n" +
                        "L\n" +
                        "L\n" +
                        "L",
                        "-1"
                )
        );
    }
    // spotless:on
}
