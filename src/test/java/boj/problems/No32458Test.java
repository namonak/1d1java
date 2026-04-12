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

class No32458Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("Just Round Down : https://www.acmicpc.net/problem/32458")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No32458.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "1999.99",
                        "1999"
                ),
                arguments(
                        "2.00000",
                        "2"
                )
        );
    }
    // spotless:on
}
