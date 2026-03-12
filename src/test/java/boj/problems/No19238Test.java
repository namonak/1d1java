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

class No19238Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("스타트 택시 : https://www.acmicpc.net/problem/19238")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No19238.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "6 3 15\n" +
                        "0 0 1 0 0 0\n" +
                        "0 0 1 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 1 0\n" +
                        "0 0 0 1 0 0\n" +
                        "6 5\n" +
                        "2 2 5 6\n" +
                        "5 4 1 6\n" +
                        "4 2 3 5",
                        "14"
                ),
                arguments(
                        "6 3 13\n" +
                        "0 0 1 0 0 0\n" +
                        "0 0 1 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 1 0\n" +
                        "0 0 0 1 0 0\n" +
                        "6 5\n" +
                        "2 2 5 6\n" +
                        "5 4 1 6\n" +
                        "4 2 3 5",
                        "-1"
                ),
                arguments(
                        "6 3 100\n" +
                        "0 0 1 0 0 0\n" +
                        "0 0 1 0 0 0\n" +
                        "0 0 0 1 0 0\n" +
                        "0 0 0 1 0 0\n" +
                        "0 0 0 0 1 0\n" +
                        "0 0 0 1 0 0\n" +
                        "6 5\n" +
                        "2 2 5 6\n" +
                        "5 4 1 6\n" +
                        "4 2 3 5",
                        "-1"
                )
        );
    }
    // spotless:on
}
