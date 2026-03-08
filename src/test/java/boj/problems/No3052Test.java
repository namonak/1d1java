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

class No3052Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("나머지 : https://www.acmicpc.net/problem/3052")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No3052.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5\n" +
                        "6\n" +
                        "7\n" +
                        "8\n" +
                        "9\n" +
                        "10",
                        "10"
                ),
                arguments(
                        "42\n" +
                        "84\n" +
                        "252\n" +
                        "420\n" +
                        "840\n" +
                        "126\n" +
                        "42\n" +
                        "84\n" +
                        "420\n" +
                        "126",
                        "1"
                ),
                arguments(
                        "39\n" +
                        "40\n" +
                        "41\n" +
                        "42\n" +
                        "43\n" +
                        "44\n" +
                        "82\n" +
                        "83\n" +
                        "84\n" +
                        "85",
                        "6"
                )
        );
    }
    // spotless:on
}
