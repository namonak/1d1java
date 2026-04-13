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

class No15681Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("트리와 쿼리 : https://www.acmicpc.net/problem/15681")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No15681.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "9 5 3\n" +
                        "1 3\n" +
                        "4 3\n" +
                        "5 4\n" +
                        "5 6\n" +
                        "6 7\n" +
                        "2 3\n" +
                        "9 6\n" +
                        "6 8\n" +
                        "5\n" +
                        "4\n" +
                        "8",
                        "9\n" +
                        "4\n" +
                        "1\n"
                )
        );
    }
    // spotless:on
}
