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

class No14889Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("스타트와 링크 : https://www.acmicpc.net/problem/14889")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No14889.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "4\n" +
                        "0 1 2 3\n" +
                        "4 0 5 6\n" +
                        "7 1 0 2\n" +
                        "3 4 5 0",
                        "0"
                ),
                arguments(
                        "6\n" +
                        "0 1 2 3 4 5\n" +
                        "1 0 2 3 4 5\n" +
                        "1 2 0 3 4 5\n" +
                        "1 2 3 0 4 5\n" +
                        "1 2 3 4 0 5\n" +
                        "1 2 3 4 5 0",
                        "2"
                ),
                arguments(
                        "8\n" +
                        "0 5 4 5 4 5 4 5\n" +
                        "4 0 5 1 2 3 4 5\n" +
                        "9 8 0 1 2 3 1 2\n" +
                        "9 9 9 0 9 9 9 9\n" +
                        "1 1 1 1 0 1 1 1\n" +
                        "8 7 6 5 4 0 3 2\n" +
                        "9 1 9 1 9 1 0 9\n" +
                        "6 5 4 3 2 1 9 0",
                        "1"
                )
        );
    }
    // spotless:on
}
