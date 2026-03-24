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

class No14502Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("연구소 : https://www.acmicpc.net/problem/14502")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No14502.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "7 7\n" +
                        "2 0 0 0 1 1 0\n" +
                        "0 0 1 0 1 2 0\n" +
                        "0 1 1 0 1 0 0\n" +
                        "0 1 0 0 0 0 0\n" +
                        "0 0 0 0 0 1 1\n" +
                        "0 1 0 0 0 0 0\n" +
                        "0 1 0 0 0 0 0",
                        "27"
                ),
                arguments(
                        "4 6\n" +
                        "0 0 0 0 0 0\n" +
                        "1 0 0 0 0 2\n" +
                        "1 1 1 0 0 2\n" +
                        "0 0 0 0 0 2",
                        "9"
                ),
                arguments(
                        "8 8\n" +
                        "2 0 0 0 0 0 0 2\n" +
                        "2 0 0 0 0 0 0 2\n" +
                        "2 0 0 0 0 0 0 2\n" +
                        "2 0 0 0 0 0 0 2\n" +
                        "2 0 0 0 0 0 0 2\n" +
                        "0 0 0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0 0 0",
                        "3"
                )
        );
    }
    // spotless:on
}
