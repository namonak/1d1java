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

class No10000Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("원 영역 : https://www.acmicpc.net/problem/10000")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No10000.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "2\n" +
                        "1 3\n" +
                        "5 1",
                        "3"
                ),
                arguments(
                        "3\n" +
                        "2 2\n" +
                        "1 1\n" +
                        "3 1",
                        "5"
                ),
                arguments(
                        "4\n" +
                        "7 5\n" +
                        "-9 11\n" +
                        "11 9\n" +
                        "0 20",
                        "6"
                ),
                arguments(
                        "1\n" +
                        "0 5",
                        "2"
                ),
                arguments(
                        "2\n" +
                        "0 10\n" +
                        "0 5",
                        "3"
                ),
                arguments(
                        "3\n" +
                        "5 5\n" +
                        "2 2\n" +
                        "7 3",
                        "5"
                ),
                arguments(
                        "5\n" +
                        "10 10\n" +
                        "5 5\n" +
                        "15 5\n" +
                        "2 2\n" +
                        "7 3",
                        "8"
                )
        );
    }
    // spotless:on
}
