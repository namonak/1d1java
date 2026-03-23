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

class No21608Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("상어 초등학교 : https://www.acmicpc.net/problem/21608")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No21608.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3\n" +
                        "4 2 5 1 7\n" +
                        "3 1 9 4 5\n" +
                        "9 8 1 2 3\n" +
                        "8 1 9 3 4\n" +
                        "7 2 3 4 8\n" +
                        "1 9 2 5 7\n" +
                        "6 5 2 3 4\n" +
                        "5 1 9 2 8\n" +
                        "2 9 3 1 4",
                        "54"
                ),
                arguments(
                        "3\n" +
                        "4 2 5 1 7\n" +
                        "2 1 9 4 5\n" +
                        "5 8 1 4 3\n" +
                        "1 2 9 3 4\n" +
                        "7 2 3 4 8\n" +
                        "9 8 4 5 7\n" +
                        "6 5 2 3 4\n" +
                        "8 4 9 2 1\n" +
                        "3 9 2 1 4",
                        "1053"
                ),
                arguments(
                        "3\n" +
                        "1 2 3 4 5\n" +
                        "2 1 3 4 5\n" +
                        "3 1 2 4 5\n" +
                        "4 1 2 3 5\n" +
                        "5 1 2 3 4\n" +
                        "6 1 2 3 4\n" +
                        "7 1 2 3 4\n" +
                        "8 1 2 3 4\n" +
                        "9 1 2 3 4",
                        "134"
                ),
                arguments(
                        "3\n" +
                        "1 2 3 4 5\n" +
                        "2 3 4 5 6\n" +
                        "3 4 5 6 7\n" +
                        "4 5 6 7 8\n" +
                        "5 6 7 8 9\n" +
                        "6 7 8 9 1\n" +
                        "7 8 9 1 2\n" +
                        "8 9 1 2 3\n" +
                        "9 1 2 3 4",
                        "44"
                )
        );
    }
    // spotless:on
}
