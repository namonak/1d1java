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

class No1019Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("책 페이지 : https://www.acmicpc.net/problem/1019")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1019.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "11",
                        "1 4 1 1 1 1 1 1 1 1"
                ),
                arguments(
                        "7",
                        "0 1 1 1 1 1 1 1 0 0"
                ),
                arguments(
                        "19",
                        "1 12 2 2 2 2 2 2 2 2"
                ),
                arguments(
                        "999",
                        "189 300 300 300 300 300 300 300 300 300"
                ),
                arguments(
                        "543212345",
                        "429904664 541008121 540917467 540117067 533117017 473117011 429904664 429904664 429904664 429904664"
                )
        );
    }
    // spotless:on
}
