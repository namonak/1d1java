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

class No4344Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("곱셈 : https://www.acmicpc.net/problem/4344")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No4344.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "5\n" +
                        "5 50 50 70 80 100\n" +
                        "7 100 95 90 80 70 60 50\n" +
                        "3 70 90 80\n" +
                        "3 70 90 81\n" +
                        "9 100 99 98 97 96 95 94 93 91",
                        "40.000%\n" +
                        "57.143%\n" +
                        "33.333%\n" +
                        "66.667%\n" +
                        "55.556%"
                )
        );
    }
    // spotless:on
}
