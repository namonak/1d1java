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

class No1183Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("약속 : https://www.acmicpc.net/problem/1183")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1183.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "1\n" +
                        "10 9",
                        "1"
                ),
                arguments(
                        "2\n" +
                        "20 18\n" +
                        "30 25",
                        "4"
                ),
                arguments(
                        "2\n" +
                        "10 11\n" +
                        "20 17",
                        "5"
                ),
                arguments(
                        "3\n" +
                        "10 13\n" +
                        "20 15\n" +
                        "30 34",
                        "1"
                ),
                arguments(
                        "4\n" +
                        "10 14\n" +
                        "20 24\n" +
                        "30 39\n" +
                        "40 37",
                        "1"
                )
        );
    }
    // spotless:on
}
