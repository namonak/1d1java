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

class No6549Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("히스토그램에서 가장 큰 직사각형 : https://www.acmicpc.net/problem/6549")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No6549.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "7 2 1 4 5 1 3 3\n" +
                        "4 1000 1000 1000 1000\n" +
                        "0",
                        "8\n" +
                        "4000"
                ),
                arguments(
                        "1 7\n" +
                        "0",
                        "7"
                ),
                arguments(
                        "4 5 5 5 5\n" +
                        "0",
                        "20"
                ),
                arguments(
                        "5 1 2 3 4 5\n" +
                        "0",
                        "9"
                ),
                arguments(
                        "5 5 4 3 2 1\n" +
                        "0",
                        "9"
                ),
                arguments(
                        "3 2 0 2\n" +
                        "0",
                        "2"
                ),
                arguments(
                        "3 1000000000 1000000000 1000000000\n" +
                        "0",
                        "3000000000"
                ),
                arguments(
                        "3 2 1 2\n" +
                        "0",
                        "3"
                )
        );
    }
    // spotless:on
}
