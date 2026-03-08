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

class No15683Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("감시 : https://www.acmicpc.net/problem/15683")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No15683.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "4 6\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 1 0 6 0\n" +
                        "0 0 0 0 0 0",
                        "20"
                ),
                arguments(
                        "6 6\n" +
                        "0 0 0 0 0 0\n" +
                        "0 2 0 0 0 0\n" +
                        "0 0 0 0 6 0\n" +
                        "0 6 0 0 2 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 5",
                        "15"
                ),
                arguments(
                        "6 6\n" +
                        "1 0 0 0 0 0\n" +
                        "0 1 0 0 0 0\n" +
                        "0 0 1 0 0 0\n" +
                        "0 0 0 1 0 0\n" +
                        "0 0 0 0 1 0\n" +
                        "0 0 0 0 0 1",
                        "6"
                ),
                arguments(
                        "6 6\n" +
                        "1 0 0 0 0 0\n" +
                        "0 1 0 0 0 0\n" +
                        "0 0 1 5 0 0\n" +
                        "0 0 5 1 0 0\n" +
                        "0 0 0 0 1 0\n" +
                        "0 0 0 0 0 1",
                        "2"
                ),
                arguments(
                        "1 7\n" +
                        "0 1 2 3 4 5 6",
                        "0"
                ),
                arguments(
                        "3 7\n" +
                        "4 0 0 0 0 0 0\n" +
                        "0 0 0 2 0 0 0\n" +
                        "0 0 0 0 0 0 4",
                        "0"
                )
        );
    }
    // spotless:on
}
