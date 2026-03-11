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

class No20061Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("모노미노도미노 2 : https://www.acmicpc.net/problem/20061")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No20061.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "1\n" +
                        "1 1 1",
                        "0\n" +
                        "2"
                ),
                arguments(
                        "2\n" +
                        "1 1 1\n" +
                        "2 3 0",
                        "0\n" +
                        "6"
                ),
                arguments(
                        "4\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3",
                        "1\n" +
                        "10"
                ),
                arguments(
                        "5\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3",
                        "1\n" +
                        "12"
                ),
                arguments(
                        "6\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3\n" +
                        "2 0 0",
                        "1\n" +
                        "16"
                ),
                arguments(
                        "7\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3\n" +
                        "2 0 0\n" +
                        "3 2 0",
                        "1\n" +
                        "18"
                ),
                arguments(
                        "8\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3\n" +
                        "2 0 0\n" +
                        "3 2 0\n" +
                        "3 1 2",
                        "2\n" +
                        "15"
                )
        );
    }
    // spotless:on
}
