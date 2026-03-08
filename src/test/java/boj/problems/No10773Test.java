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

class No10773Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("제로 : https://www.acmicpc.net/problem/10773")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No10773.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "4\n" +
                        "3\n" +
                        "0\n" +
                        "4\n" +
                        "0",
                        "0"
                ),
                arguments(
                        "10\n" +
                        "1\n" +
                        "3\n" +
                        "5\n" +
                        "4\n" +
                        "0\n" +
                        "0\n" +
                        "7\n" +
                        "0\n" +
                        "0\n" +
                        "6",
                        "7"
                )
        );
    }
    // spotless:on
}
