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

class No1206Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("사람의 수 : https://www.acmicpc.net/problem/1206")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1206.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3\n" +
                        "0.500\n" +
                        "0.250\n" +
                        "0.125",
                        "8"
                ),
                arguments(
                        "1\n" +
                        "0.000",
                        "1"
                ),
                arguments(
                        "2\n" +
                        "0.500\n" +
                        "0.300",
                        "10"
                ),
                arguments(
                        "2\n" +
                        "0.500\n" +
                        "0.301",
                        "106"
                )
        );
    }
    // spotless:on
}
