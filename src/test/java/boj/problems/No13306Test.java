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

class No13306Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("트리 : https://www.acmicpc.net/problem/13306")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No13306.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3 3\n" +
                        "1\n" +
                        "1\n" +
                        "1 2 3\n" +
                        "0 3\n" +
                        "1 2 3\n" +
                        "1 1 2\n" +
                        "0 2",
                        "YES\n" +
                        "NO\n" +
                        "YES"
                ),
                arguments(
                        "11 5\n" +
                        "7\n" +
                        "4\n" +
                        "1\n" +
                        "9\n" +
                        "11\n" +
                        "1\n" +
                        "11\n" +
                        "1\n" +
                        "3\n" +
                        "7\n" +
                        "0 11\n" +
                        "1 8 5\n" +
                        "1 3 9\n" +
                        "0 10\n" +
                        "0 9\n" +
                        "0 7\n" +
                        "1 2 7\n" +
                        "0 5\n" +
                        "1 1 10\n" +
                        "0 8\n" +
                        "0 6\n" +
                        "0 2\n" +
                        "1 1 3\n" +
                        "0 3\n" +
                        "0 4",
                        "NO\n" +
                        "YES\n" +
                        "YES\n" +
                        "NO\n" +
                        "YES"
                )
        );
    }
    // spotless:on
}
